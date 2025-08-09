package com.wipro.riderservice.dto;
import java.time.LocalDate;

import lombok.*;

@Data
public class RideRequest {
    private int id;
    private String riderName;
    private String pickupLocation;
    private String dropLocation;
    private boolean rideAccepted;
    private LocalDate requestTime;
}