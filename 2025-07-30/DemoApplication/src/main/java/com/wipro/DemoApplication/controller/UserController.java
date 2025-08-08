package com.wipro.DemoApplication.controller;
import com.wipro.DemoApplication.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/userreg")
    public String showRegistrationForm() {
        return "userreg";
    }

    @PostMapping("/register")
    public String handleRegistration(@ModelAttribute User user) {
        System.out.println("Received data " + user);
        return "success";
    }
}

