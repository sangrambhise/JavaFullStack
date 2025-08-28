package com.wipro.orderms.service.impl;

import com.wipro.common.dto.OrderPlacedEvent;
import com.wipro.orderms.dto.OrderResponse;
import com.wipro.orderms.dto.Payment;
import com.wipro.orderms.entity.Order;
import com.wipro.orderms.feign.PaymentConnectService;
import com.wipro.orderms.repo.OrderRepo;
import com.wipro.orderms.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
	
	
    @Autowired
    private OrderRepo orderRepo;
    
    @Autowired private KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private PaymentConnectService paymentClient;
   
    @Override
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackForGetAllOrders")
    public List<OrderResponse> getAllOrdersWithPayments() {
        List<Order> orders = orderRepo.findAll();
        List<OrderResponse> responseList = new ArrayList<>();

        for (Order order : orders) {
            OrderResponse response = new OrderResponse();
            response.setOrderNumber(order.getOrderNumber());
            response.setOrderValue(order.getOrderValue());
            response.setOrderStatus(order.getOrderStatus());

//            try {
                List<Payment> payments = paymentClient.getPaymentsByOrderId(order.getId());
                response.setPayments(payments);
//            } catch (Exception e) {
//                response.setPayments(new ArrayList<>());
//            }

            responseList.add(response);
        }

        return responseList;
    }


    @Override
    @CircuitBreaker(name = "orderService", fallbackMethod = "fallbackForPaymentService")
    public Order placeOrder(Order order) {
        order.setOrderStatus("I");
        orderRepo.save(order);
        OrderPlacedEvent event = new OrderPlacedEvent(order.getId(), order.getOrderValue());
        kafkaTemplate.send("order-events", event);
        Payment payment = new Payment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getOrderValue());
        payment.setDescription("Payment for Order #" + order.getOrderNumber());
        payment.setPaymentMode("UPI");

//        try {
            ResponseEntity<String> response = paymentClient.savePaymentData(payment);
            if (response.getStatusCode() == HttpStatus.CREATED) {
                order.setOrderStatus("P"); 
            } else {
                order.setOrderStatus("C"); 
            }
//        } catch (Exception e) {
//            order.setOrderStatus("C");
//        }

        return orderRepo.save(order);
    }
    
    public Order fallbackForPaymentService(Order order, Throwable t) {
        order.setOrderStatus("C");
        System.out.println("Fallback triggered");
        return orderRepo.save(order);
    }

    public List<OrderResponse> fallbackForGetAllOrders(Throwable t) {
        System.out.println("Fallback triggered ");    
    		return new ArrayList<>();
    }


//  @Override
//  public List<OrderResponse> getAllOrdersWithPayments() {
//      List<Order> orders = orderRepo.findAll();
//      List<OrderResponse> responseList = new ArrayList<>();
//      RestTemplate restTemplate = new RestTemplate();
//
//      for (Order order : orders) {
//          OrderResponse response = new OrderResponse();
//          response.setOrderNumber(order.getOrderNumber());
//          response.setOrderValue(order.getOrderValue());
//          response.setOrderStatus(order.getOrderStatus());
//
//          try {
////          String url = "http://localhost:9011/payments/byOrderId/" + order.getId();
//          String url = "http://payment-ms/payments/byOrderId/" + order.getId();
//          Payment[] payments = restTemplate.getForObject(url, Payment[].class);
//          response.setPayments(Arrays.asList(payments));
//
//          responseList.add(response);
//      }catch (Exception e) {
//          response.setPayments(new ArrayList<>());
//      }
//          responseList.add(response);
//  }
//      return responseList;
//  }
    
    
    
    
//    @Override
//    public Order placeOrder(Order order) {
//        order.setOrderStatus("I");
//        orderRepo.save(order);
//
//        Payment payment = new Payment();
//        payment.setOrderId(order.getId());
//        payment.setAmount(order.getOrderValue());
//        payment.setDescription("Payment for Order #" + order.getOrderNumber());
//        payment.setPaymentMode("UPI");
//
//        try {
////            RestTemplate restTemplate = new RestTemplate();
////            String url = "http://localhost:9011/payments";
//        		String url = "http://payment-ms/payments";
//        		ResponseEntity<String> response = restTemplate.postForEntity(url, payment, String.class);
//            if (response.getStatusCode() == HttpStatus.CREATED) {
//                order.setOrderStatus("P");
//            } else {
//                order.setOrderStatus("C");
//            }
//
//        } catch (Exception e) {
//            order.setOrderStatus("C");
//        }
//
//        return orderRepo.save(order);
//    }
}
