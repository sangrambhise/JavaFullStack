package com.wipro.ecom.product.service;

import com.wipro.ecom.product.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getById(Long id);
    Product create(Product product);
    Product update(Long id, Product product);
    void delete(Long id);
}
