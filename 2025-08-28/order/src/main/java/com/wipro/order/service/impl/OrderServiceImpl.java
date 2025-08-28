package com.wipro.order.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.order.dto.Food;
import com.wipro.order.dto.Payment;
import com.wipro.order.entity.OrderEntity;
import com.wipro.order.entity.OrderMaster;
import com.wipro.order.repo.OrderMasterRepo;
import com.wipro.order.repo.OrderRepo;
import com.wipro.order.service.OrderService;
import com.wipro.order.util.AppConstant;
 

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	OrderMasterRepo orderMasterRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	KafkaTemplate kafkaTemplate;
 
	public List<OrderEntity> findAll() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

 
	public OrderEntity findById(int id) {
		// TODO Auto-generated method stub
		Optional<OrderEntity> orderOpt= orderRepo.findById(id);
		if(orderOpt.isPresent())
		{
			return orderOpt.get();
		}
		return null;
	}

	public OrderEntity save(OrderEntity order,String token) {
		List<OrderMaster> masters = orderMasterRepo.findAll();
	    OrderMaster last = masters.get(masters.size() - 1);
	    int newVal = last.getValue() + 1;
	    last.setValue(newVal);
	    orderMasterRepo.save(last);

	    order.setOrderId(String.format("ORD-%04d", newVal));
		order.setOrderStatus(0);
		
		 String url = "http://FOOD-MS/food/" + order.getFoodId();
		    HttpHeaders headers = new HttpHeaders();
		    headers.set("Authorization", token);
		    HttpEntity<String> entity = new HttpEntity<>(headers);

		    ResponseEntity<Food> response = restTemplate.exchange(url, HttpMethod.GET, entity, Food.class);
		    Food food = response.getBody();

		    order.setTotalOrderPrice(order.getOrderQty() * food.getPrice());
		    orderRepo.save(order);
		    return order;
	}

 
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		orderRepo.deleteById(id);
	}


	@Override
	public void pay(Payment payment) {
		// TODO Auto-generated method stub
		kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME,payment)	;
	}


}
