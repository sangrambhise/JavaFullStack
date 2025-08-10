package com.wipro.orderms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderNumber;
    private double orderValue;
    private String orderStatus;
}
