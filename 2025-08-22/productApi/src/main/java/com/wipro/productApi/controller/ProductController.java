package com.wipro.productApi.controller;


import com.wipro.productApi.entity.Order;
import com.wipro.productApi.entity.Product;
import com.wipro.productApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
//Ex3
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        service.save(product);
    }

    @PutMapping("/{id}")
    void update(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        service.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }    
    
    @PostMapping("/purchase")
    public ResponseEntity<Void> purchase(@RequestBody Map<String, Integer> payload) {
        int productId = payload.get("productId");
        int qty = payload.get("quantity");

        if (service.purchase(productId, qty)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return service.getOrders();
    }

}
