package com.wipro.foodms.controller;

import com.wipro.foodms.entity.Food;
import com.wipro.foodms.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
//@CrossOrigin(origins = "*")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods() {
        return ResponseEntity.ok(foodService.getAllFoods());
    }

    @PostMapping
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        try {
            Food savedFood = foodService.saveFood(food);
            return ResponseEntity.ok(savedFood);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);  // Internal server error
        }
    }
}
