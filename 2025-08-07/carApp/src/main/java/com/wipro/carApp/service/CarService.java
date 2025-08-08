package com.wipro.carApp.service;

import com.wipro.carApp.entity.Car;


import java.util.List;
import java.util.Optional;
public interface CarService {
    Car saveCar(Car car);
    List<Car> getAllCars();
    Optional<Car> getCarById(Long id);
    Car updateCar(Long id, Car car);
    void deleteCar(Long id);
}