package com.wipro.productApi.service;

import com.wipro.productApi.entity.Product;
import com.wipro.productApi.entity.Order;
import java.util.List;

//Ex3
public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void deleteById(int id);
    boolean purchase(int productId, int qty);
    List<Order> getOrders();   
}
