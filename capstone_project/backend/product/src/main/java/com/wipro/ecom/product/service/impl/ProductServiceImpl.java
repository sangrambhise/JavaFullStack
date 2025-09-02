package com.wipro.ecom.product.service.impl;

import com.wipro.ecom.product.entity.Product;
import com.wipro.ecom.product.repo.ProductRepository;
import com.wipro.ecom.product.service.ProductService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private static final String CB_NAME = "defaultCB";
    
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @CircuitBreaker(name = CB_NAME, fallbackMethod = "getAllFallback")
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    
    public List<Product> getAllFallback(Throwable ex) {
        return List.of(); 
    }

    @Override
    @CircuitBreaker(name = CB_NAME, fallbackMethod = "getByIdFallback")
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }
    
    public Optional<Product> getByIdFallback(Long id, Throwable ex) {
        return Optional.empty();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
    

    @Override
    public Product update(Long id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setProdName(product.getProdName());
        existing.setProdDesc(product.getProdDesc());
        existing.setProdCat(product.getProdCat());
        existing.setMake(product.getMake());
        existing.setAvailableQty(product.getAvailableQty());
        existing.setPrice(product.getPrice());
        existing.setUom(product.getUom());
        existing.setProdRating(product.getProdRating());
        existing.setImageURL(product.getImageURL());
        existing.setDateOfManufacture(product.getDateOfManufacture());

        return productRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
