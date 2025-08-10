package com.wipro.orderms.service;
import java.util.List;

import com.wipro.orderms.dto.OrderResponse;
import com.wipro.orderms.entity.Order;
public interface OrderService {
    Order placeOrder(Order order);
    List<OrderResponse> getAllOrdersWithPayments();

}
