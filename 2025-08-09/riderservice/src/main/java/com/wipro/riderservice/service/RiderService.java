package com.wipro.riderservice.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.riderservice.dto.RideRequest;
import com.wipro.riderservice.entity.Ride;
import com.wipro.riderservice.repo.RiderRepo;

@Service
public class RiderService {

    @Autowired
    RiderRepo riderRepo;

    @Autowired
    @Qualifier("riderKafkaTemplate")
    KafkaTemplate<String, RideRequest> kafkaTemplate;

    public void bookRide(RideRequest request) {
        request.setRideAccepted(false);
        request.setRequestTime(LocalDate.now());

        Ride ride = new Ride();
        BeanUtils.copyProperties(request, ride);
        Ride saved = riderRepo.save(ride);
        request.setId(saved.getId());

        kafkaTemplate.send("RIDER_TO_UBER", request);
        System.out.println("Sent ride request to Kafka: " + request);
    }

    @KafkaListener(topics = "UBER_TO_RIDER", groupId = "rider_group")
    public void receiveRideStatus(RideRequest response) {
        Ride ride = riderRepo.findById(response.getId()).orElse(null);
        if (ride != null) {
            ride.setRideAccepted(response.isRideAccepted());
            riderRepo.save(ride);
            System.out.println("Uber accepted your ride: " + response);
        } else {
            System.out.println("Ride not found for id: " + response.getId());
        }
    }

}
