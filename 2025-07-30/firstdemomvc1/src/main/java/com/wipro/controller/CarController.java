package com.wipro.controller;


import com.wipro.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/list")
    public String showCarList(Model model) {
        model.addAttribute("carList", carService.getAllCars());
        return "carlist";
    }
}
