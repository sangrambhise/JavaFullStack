package com.wipro.uberservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.uberservice.dto.RideRequest;
import com.wipro.uberservice.entity.Driver;
import com.wipro.uberservice.repo.DriverRepo;

@Service
public class UberService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    KafkaTemplate<String, RideRequest> kafkaTemplate;

    @KafkaListener(topics = "RIDER_TO_UBER", groupId = "uber_group")
    public void assignDriver(RideRequest request) {
        System.out.println("Received ride request: " + request);

        Driver driver = driverRepo.findFirstByAvailableTrue();

        if (driver != null) {
            driver.setAvailable(false);
            driverRepo.save(driver);
            request.setRideAccepted(true);
        } else {
            request.setRideAccepted(false);
        }

        kafkaTemplate.send("UBER_TO_RIDER", request);
    }
}

