package com.wipro.service;
import com.wipro.repository.CarRepository;
import java.util.List;

public class CarService {
    private CarRepository repo = new CarRepository();

    public List<String> getAllCars() {
        return repo.getCarNames();
    }
}
