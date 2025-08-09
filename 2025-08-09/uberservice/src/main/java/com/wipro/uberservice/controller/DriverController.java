package com.wipro.uberservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.uberservice.entity.Driver;
import com.wipro.uberservice.repo.DriverRepo;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverRepo driverRepo;

    @PostMapping("/complete-ride/{driverId}")
    public ResponseEntity<String> completeRide(@PathVariable int driverId) {
        Driver driver = driverRepo.findById(driverId).orElse(null);
        if (driver != null) {
            driver.setAvailable(true);
            driverRepo.save(driver);
            return ResponseEntity.ok("Driver marked available.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
