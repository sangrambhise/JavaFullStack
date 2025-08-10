package com.wipro.orderms.dto;

import lombok.Data;

@Data
public class Payment {
//    private int id;
    private String paymentMode;
    private double amount;
    private String description;
    private boolean paymentStatus;
    private int orderId;
}