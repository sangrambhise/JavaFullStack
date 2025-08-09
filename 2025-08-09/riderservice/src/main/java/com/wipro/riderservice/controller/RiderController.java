package com.wipro.riderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.riderservice.constants.KafkaTopics;
import com.wipro.shared.dto.RideRequest;
import com.wipro.riderservice.service.RiderService;

@RestController
@RequestMapping("/rider")
public class RiderController {

	@Autowired
	@Qualifier("riderKafkaTemplate")
	private KafkaTemplate<String, RideRequest> kafkaTemplate;
	
    @Autowired
    RiderService riderService;
    
    @PostMapping("/book")
    public ResponseEntity<String> bookRide(@RequestBody RideRequest request) {
        riderService.bookRide(request);
        System.out.println("Ride request received: " + request);
        return ResponseEntity.ok("Ride request submitted successfully with id: " + request.getId());
    }
    
    
}

