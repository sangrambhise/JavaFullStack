package com.wipro.letsgo.service;

import com.wipro.letsgo.dto.VehicleMovementRequest;
import com.wipro.letsgo.entity.VehicleMovement;

public interface VehicleMovementService {
    VehicleMovement saveMovement(VehicleMovementRequest request);
}


