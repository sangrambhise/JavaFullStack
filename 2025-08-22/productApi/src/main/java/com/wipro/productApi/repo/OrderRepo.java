package com.wipro.productApi.repo;

import com.wipro.productApi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
//Ex3
public interface OrderRepo extends JpaRepository<Order, Integer> {
}

