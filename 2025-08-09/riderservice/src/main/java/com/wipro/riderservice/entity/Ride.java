package com.wipro.riderservice.entity;

import lombok.Data;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "ride")
@Data
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String riderName;
    private String pickupLocation;
    private String dropLocation;
    private boolean rideAccepted;
    private LocalDate requestTime;
}
