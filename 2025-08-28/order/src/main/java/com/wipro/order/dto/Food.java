package com.wipro.order.dto;

import lombok.Data;

@Data
public class Food {
  private int id;
  private String name;
  private double price;
  private String description;
  private String imageUrl;
  private String category;
  private int orderQty;
}
