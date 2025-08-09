package com.wipro.riderservice.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.riderservice.constants.KafkaTopics;
import com.wipro.shared.dto.RideRequest;
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

        kafkaTemplate.send(KafkaTopics.RIDER_TO_UBER, request);
        System.out.println("Sent ride request to Kafka: " + request);
    }

    @KafkaListener(topics = KafkaTopics.UBER_TO_RIDER, groupId = "rider-service-group")
    public void receiveRideStatus(RideRequest response) {
    	System.out.println("Received ride status: " + response);
    	Ride ride = riderRepo.findById(response.getId()).orElse(null);
        if (ride != null) {
            ride.setRideAccepted(response.isRideAccepted());
            ride.setPrice(response.getPrice()); 
            riderRepo.save(ride);
            System.out.println("Uber accepted your ride: " + response);
        } else {
            System.out.println("Ride not found for id: " + response.getId());
        }
    }


}
