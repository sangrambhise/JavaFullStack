package com.wipro.jwtDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TimeController {

    @GetMapping("/getCurrentTime")
    public String getCurrentTime() {
        return "Current time: " + LocalDateTime.now();
    }
}
