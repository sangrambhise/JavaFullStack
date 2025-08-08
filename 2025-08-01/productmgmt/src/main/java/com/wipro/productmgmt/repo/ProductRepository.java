package com.wipro.productmgmt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.productmgmt.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByProductMake(String productMake);
	List<Product> findByProductNameAndProductMakeOrderByProductNameDesc(String productName, String productMake);

}
