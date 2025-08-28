package com.wipro.foodms.service.impl;

import com.wipro.foodms.entity.Food;
import com.wipro.foodms.repo.FoodRepo;
import com.wipro.foodms.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepo foodRepo;

    @Override
    public List<Food> getAllFoods() {
        return foodRepo.findAll();
    }

    @Override
    public Food saveFood(Food food) {
        return foodRepo.save(food);
    }

    @Override
    public Food findById(int id) {
        Optional<Food> optionalFood = foodRepo.findById(id);
        return optionalFood.orElse(null); 
    }

    @Override
    public void deleteById(int id) {
        foodRepo.deleteById(id);
    }
}
