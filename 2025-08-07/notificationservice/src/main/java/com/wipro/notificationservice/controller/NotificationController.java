package com.wipro.notificationservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.notificationservice.dto.UserNotificationDTO;
@RestController
public class NotificationController {

    @PostMapping("/notify")
    public ResponseEntity<String> notifyUser(@RequestBody UserNotificationDTO dto) {
        System.out.println(dto.getUser().getUsername() + " is " + dto.getAction());
        return ResponseEntity.ok("Notification Sent");
    }
}
