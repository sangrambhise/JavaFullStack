package com.wipro.order.entity;

 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="order_details")
@Data
public class OrderEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "order_id")
    String orderId;

    @Column(name = "user_id")
    int userId;

    @Column(name = "food_id")
    String foodId;

    @Column(name = "order_qty")
    int orderQty;

    @Column(name = "order_price")
    double totalOrderPrice;

    @Column(name = "order_status")
    int orderStatus;

}
