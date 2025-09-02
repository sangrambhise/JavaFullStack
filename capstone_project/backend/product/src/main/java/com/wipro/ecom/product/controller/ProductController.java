package com.wipro.ecom.product.controller;

import com.wipro.ecom.events.OrderEvent;
import com.wipro.ecom.events.ProductEvent;
import com.wipro.ecom.product.entity.Product;
import com.wipro.ecom.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    private KafkaTemplate<String, ProductEvent> kafkaTemplate;
    
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.getById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("Product not found"));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product saved = service.create(product);
        ProductEvent event = new ProductEvent(
                saved.getId().longValue(), "CREATED", saved.getStock());
        kafkaTemplate.send("product-topic", event);

        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product product) {
        Product updated = service.update(id, product);
        ProductEvent event = new ProductEvent(
                updated.getId().longValue(), "UPDATED", updated.getStock());
        kafkaTemplate.send("product-topic", event);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        ProductEvent event = new ProductEvent(id, "DELETED", 0);
        kafkaTemplate.send("product-topic", event);

        return ResponseEntity.ok("Deleted");
    }
   
    
    @KafkaListener(topics = "order-topic", groupId = "product-group")
    public void consumeOrderEvent(OrderEvent event) {
        System.out.println("Product Service received order event: " + event);
    }
}
