package com.wipro.foodms.repo;

import com.wipro.foodms.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Integer> {}
