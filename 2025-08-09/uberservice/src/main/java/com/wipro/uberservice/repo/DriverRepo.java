package com.wipro.uberservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.uberservice.entity.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer> {
    Driver findFirstByAvailableTrue();
}
