package com.wipro.uberservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.uberservice.constants.KafkaTopics;
import com.wipro.shared.dto.RideRequest;
import com.wipro.uberservice.entity.Driver;
import com.wipro.uberservice.repo.DriverRepo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class UberService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    @Qualifier("uberKafkaTemplate")
    KafkaTemplate<String, RideRequest> kafkaTemplate;

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @KafkaListener(topics = KafkaTopics.RIDER_TO_UBER, groupId = "uber_group")
    public void assignDriver(RideRequest request) {
        System.out.println("Received ride request: " + request);
        Driver driver = driverRepo.findFirstByAvailableTrue();
        System.out.println("Driver found: " + driver);

        boolean rideAccepted = false;
        double price = 0.0;

        if (driver != null) {
            driver.setAvailable(false);
            driverRepo.save(driver);

            rideAccepted = true;
            double baseFare = 50.0;
            price = baseFare + (Math.random() * 100);
            System.out.println("Price set to: " + price);

            int driverId = driver.getId();
            scheduler.schedule(() -> {
                Driver d = driverRepo.findById(driverId).orElse(null);
                if (d != null) {
                    d.setAvailable(true);
                    driverRepo.save(d);
                    System.out.println("Driver marked available again: " + d.getName());
                }
            }, 30, TimeUnit.SECONDS); 
        } else {
            System.out.println("No driver available!");
        }

        RideRequest response = new RideRequest();
        response.setId(request.getId());
        response.setRiderName(request.getRiderName());
        response.setPickupLocation(request.getPickupLocation());
        response.setDropLocation(request.getDropLocation());
        response.setRequestTime(request.getRequestTime());
        response.setRideAccepted(rideAccepted);
        response.setPrice(price);

        System.out.println("Sending response to rider: " + response);
        kafkaTemplate.send(KafkaTopics.UBER_TO_RIDER, response);
    }
}
