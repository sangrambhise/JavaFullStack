package com.wipro.orderms.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private String orderNumber;
    private double orderValue;
    private String orderStatus;
    private List<Payment> payments;
}
