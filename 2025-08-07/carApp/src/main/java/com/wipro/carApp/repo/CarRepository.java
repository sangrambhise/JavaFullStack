package com.wipro.carApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.carApp.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {}
