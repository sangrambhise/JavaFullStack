package com.wipro.ecom.order.service.impl;

import com.wipro.ecom.order.entity.*;
import com.wipro.ecom.order.repo.CartRepository;
import com.wipro.ecom.order.repo.OrderRepository;
import com.wipro.ecom.order.service.OrderService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @CircuitBreaker(name = "orderService", fallbackMethod = "createOrderFromCartFallback")
    public Order createOrderFromCart(Long userId) {
        var cartOpt = cartRepository.findByUserId(userId);
        var cart = cartOpt.orElseThrow(() -> new RuntimeException("Cart not found for user"));

        if (cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart empty");
        }

        Order order = new Order();
        order.setUserId(userId.intValue());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PLACED);

        final double[] total = {0.0};
        Map<Integer, Integer> productMap = new HashMap<>();

        var items = cart.getItems().stream().map(ci -> {
            OrderItem oi = new OrderItem();
            oi.setProductId(ci.getProductId().intValue());
            oi.setQuantity(ci.getQuantity());
            oi.setPrice(0.0); 
            oi.setOrder(order);

            productMap.put(ci.getProductId(), ci.getQuantity());
            total[0] += 0.0;
            return oi;
        }).collect(Collectors.toSet());

        order.setItems(items);
        order.setProductQuantityMap(productMap);
        order.setTotalAmount(total[0]);

        var saved = orderRepository.save(order);
        cart.getItems().clear();
        cartRepository.save(cart);

        return saved;
    }

    public Order createOrderFromCartFallback(Long userId, Throwable t) {
        throw new RuntimeException("Order creation currently unavailable. Please try again later.", t);
    }
    
    @Override
    public Order cancelOrder(Long orderId, Long userId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        if (!order.getUserId().equals(userId)) throw new RuntimeException("Not authorized to cancel this order");
        order.setStatus(OrderStatus.CANCELLED);
        return orderRepository.save(order);
    }

    @Override
    @CircuitBreaker(name = "orderService", fallbackMethod = "getOrdersForUserFallback")
    public List<Order> getOrdersForUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
    
    public List<Order> getOrdersForUserFallback(Long userId, Throwable t) {
        return Collections.emptyList();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
    
    @Override
    public Map<OrderStatus, List<Order>> getAllOrdersGroupedByStatus() {
        return orderRepository.findAll().stream()
            .collect(Collectors.groupingBy(Order::getStatus));
    }

}
