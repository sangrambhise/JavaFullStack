package com.wipro.riderservice.repo;

import org.springframework.stereotype.Repository;

import com.wipro.riderservice.entity.Ride;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RiderRepo extends JpaRepository<Ride, Integer> {
}