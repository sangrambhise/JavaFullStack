package com.wipro.carApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.carApp.entity.Car;
import com.wipro.carApp.repo.CarRepository;
import com.wipro.carApp.service.CarService;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar == null) {
            return null; 
        }
        existingCar.setMake(car.getMake());
        existingCar.setRegistrationDetail(car.getRegistrationDetail());
        return carRepository.save(existingCar);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
