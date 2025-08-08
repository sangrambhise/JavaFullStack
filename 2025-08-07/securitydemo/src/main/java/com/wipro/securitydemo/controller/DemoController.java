package com.wipro.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, this endpoint is public!";
    }

    @GetMapping("/secure")
    public String secure() {
        return "This endpoint is secured!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin-only secured page!";
    }
}
