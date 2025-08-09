package com.wipro.shared.dto;
import java.time.LocalDate;
import lombok.Data;
@Data
public class RideRequest {
    private int id;
    private String riderName;
    private String pickupLocation;
    private String dropLocation;
    private boolean rideAccepted;
    private LocalDate requestTime;
    private double price;
}