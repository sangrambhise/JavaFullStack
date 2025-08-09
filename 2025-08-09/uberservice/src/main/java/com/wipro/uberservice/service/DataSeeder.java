package com.wipro.uberservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wipro.uberservice.entity.Driver;
import com.wipro.uberservice.repo.DriverRepo;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private DriverRepo driverRepo;

    @Override
    public void run(String... args) {
        if (driverRepo.count() == 0) {
            Driver driver = new Driver();
            driver.setName("John Doe");
            driver.setAvailable(true);
            driverRepo.save(driver);
            System.out.println("Seeded one driver into DB.");
        }
    }
}
