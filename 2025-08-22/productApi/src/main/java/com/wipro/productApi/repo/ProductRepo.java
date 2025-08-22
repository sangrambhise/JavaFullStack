package com.wipro.productApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.productApi.entity.Product;
//Ex3
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
