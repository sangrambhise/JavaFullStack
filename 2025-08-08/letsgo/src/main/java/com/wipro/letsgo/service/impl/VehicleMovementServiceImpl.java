package com.wipro.letsgo.service.impl;


import com.wipro.letsgo.dto.VehicleMovementRequest;
import com.wipro.letsgo.entity.VehicleMovement;
import com.wipro.letsgo.repo.VehicleMovementRepository;
import com.wipro.letsgo.service.VehicleMovementService;
import org.springframework.stereotype.Service;

@Service
public class VehicleMovementServiceImpl implements VehicleMovementService {

    private final VehicleMovementRepository repository;

    public VehicleMovementServiceImpl(VehicleMovementRepository repository) {
        this.repository = repository;
    }

    @Override
    public VehicleMovement saveMovement(VehicleMovementRequest request) {
        VehicleMovement movement = new VehicleMovement();
        movement.setVehId(request.getVehId());
        movement.setLat(request.getLat());
        movement.setLongitude(request.getLongitude());
        return repository.save(movement);
    }
}
