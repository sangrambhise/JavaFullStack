package com.wipro.letsgo.controller;

import com.wipro.letsgo.dto.VehicleMovementRequest;
import com.wipro.letsgo.entity.VehicleMovement;
import com.wipro.letsgo.service.VehicleMovementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class VehicleMovementController {

    private final VehicleMovementService service;

    public VehicleMovementController(VehicleMovementService service) {
        this.service = service;
    }

    @PostMapping("/move")
    public ResponseEntity<VehicleMovement> move(@RequestBody VehicleMovementRequest request) {
        VehicleMovement saved = service.saveMovement(request);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
