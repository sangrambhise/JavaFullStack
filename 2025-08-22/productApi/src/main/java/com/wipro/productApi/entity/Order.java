package com.wipro.productApi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
//	ex2
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int productId;
  private String productName;
  private int qtyPurchased;
  private LocalDateTime orderDate;
}
