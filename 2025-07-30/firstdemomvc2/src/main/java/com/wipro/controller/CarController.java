package com.wipro.controller;

import com.wipro.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
public class CarController {

    private CarService service = new CarService();

    @GetMapping("/")
    public String home() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showCarList(Model model) {
        List<String> carList = service.getAllCars();
        model.addAttribute("cars", carList);
        return "carlist";
    }
}
