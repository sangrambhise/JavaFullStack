package com.wipro.DemoApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.wipro.DemoApplication.DemoApplication;
import com.wipro.DemoApplication.service.CityService;

@Controller
public class CityController {

  @Autowired
  private CityService cityService;

  @GetMapping("/cities")
  public String getCities(Model model) {
    List<String> cities = cityService.fetchCities();
    System.out.println(cities);
    model.addAttribute("cities", cities);
    return "cities";
  }
}
