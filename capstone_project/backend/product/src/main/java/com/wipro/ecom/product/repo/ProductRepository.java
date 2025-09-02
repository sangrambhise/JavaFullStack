package com.wipro.ecom.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecom.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}