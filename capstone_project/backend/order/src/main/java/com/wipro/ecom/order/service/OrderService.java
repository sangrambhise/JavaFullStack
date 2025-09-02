package com.wipro.ecom.order.service;

import com.wipro.ecom.order.entity.Order;
import com.wipro.ecom.order.entity.OrderStatus;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Order createOrderFromCart(Long userId);
    Order cancelOrder(Long orderId, Long userId);
    List<Order> getOrdersForUser(Long userId);
    List<Order> getAllOrders();
    Order getById(Long id);
	Map<OrderStatus, List<Order>> getAllOrdersGroupedByStatus();

}
