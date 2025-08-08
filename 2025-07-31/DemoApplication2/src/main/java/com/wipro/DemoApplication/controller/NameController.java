package com.wipro.DemoApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NameController {

    @GetMapping("/newname")
    public String showName(Model model) {
        model.addAttribute("name","John");
        System.out.println("Returning to namepage.html");
        return "namepage";
    }
}
