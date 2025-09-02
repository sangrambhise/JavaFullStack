package com.wipro.ecom.order.controller;

import com.wipro.ecom.events.OrderEvent;
import com.wipro.ecom.events.ProductEvent;
import com.wipro.ecom.order.dto.OrderResponse;
import com.wipro.ecom.order.entity.Order;
import com.wipro.ecom.order.entity.OrderItem;
import com.wipro.ecom.order.entity.OrderStatus;
import com.wipro.ecom.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).build();

        Order order = orderService.createOrderFromCart(userId);
        placeOrder(order);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getMyOrders(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).build();

        List<Order> orders = orderService.getOrdersForUser(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id, HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).build();

        try {
            Order order = orderService.getById(id);
            if (!order.getUserId().equals(userId)) {
                return ResponseEntity.status(403).body("Not authorized to view this order");
            }
            return ResponseEntity.ok(order);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Order not found with id: " + id);
        }
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable Long id, HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).build();

        orderService.cancelOrder(id, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        List<OrderResponse> resp = orders.stream().map(order -> {
            OrderResponse or = new OrderResponse();
            or.setId(Long.valueOf(order.getOrderId()));
            or.setUserId(Long.valueOf(order.getUserId()));
            or.setTotalAmount(order.getTotalAmount());
            or.setOrderDate(order.getOrderDate());
            or.setStatus(order.getStatus());
            or.setItems(order.getItems());
            return or;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/all/grouped")
    public ResponseEntity<Map<OrderStatus, List<Order>>> getAllOrdersGrouped() {
        return ResponseEntity.ok(orderService.getAllOrdersGroupedByStatus());
    }

    private void placeOrder(Order order) {
        for (OrderItem item : order.getItems()) {
            OrderEvent event = new OrderEvent(
                    String.valueOf(order.getOrderId()),
                    "CREATED",
                    item.getProductId(),
                    item.getQuantity()
            );
            kafkaTemplate.send("order-topic", event);
        }
    }

    @KafkaListener(topics = "product-topic", groupId = "order-group")
    public void consumeProductEvent(ProductEvent event) {
        System.out.println("Order Service received product update: " + event);
    }
}
