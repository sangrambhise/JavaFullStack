package com.wipro.letsgo.dto;


import lombok.Data;

@Data
public class VehicleMovementRequest {
    private Long vehId;
    private Double lat;
    private Double longitude;

 
}
