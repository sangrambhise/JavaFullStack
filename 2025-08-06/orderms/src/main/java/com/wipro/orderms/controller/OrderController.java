package com.wipro.orderms.controller;
import com.wipro.orderms.dto.OrderResponse;
import com.wipro.orderms.entity.Order;
import com.wipro.orderms.service.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.placeOrder(order);
        return ResponseEntity.ok(savedOrder);
    }
    
    @PostMapping("/payments")
    public ResponseEntity<List<OrderResponse>> getOrdersWithPayments() {
        List<OrderResponse> orders = orderService.getAllOrdersWithPayments();
        return ResponseEntity.ok(orders);
    }
}
