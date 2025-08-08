package com.wipro.userservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.wipro.userservice.dto.UserNotificationDTO;



@Component
public class NotificationClient {

    @Autowired
    private RestTemplate restTemplate;


    private static final String NOTIFICATION_SERVICE_URL = "http://notificationservice/notify";


    public void notify(UserNotificationDTO dto) {
        restTemplate.postForObject(NOTIFICATION_SERVICE_URL, dto, String.class);
    }
}

