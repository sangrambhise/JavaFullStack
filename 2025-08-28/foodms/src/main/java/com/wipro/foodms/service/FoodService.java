package com.wipro.foodms.service;

import com.wipro.foodms.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAllFoods();
    Food saveFood(Food food);
	Food findById(int id);
	void deleteById(int id);
}
