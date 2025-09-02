package com.wipro.ecom.order.dto;
import com.wipro.ecom.order.entity.OrderItem;
import com.wipro.ecom.order.entity.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderResponse {
    private Long id;
    private Long userId;
    private Double totalAmount;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private Set<OrderItem> items;
}
