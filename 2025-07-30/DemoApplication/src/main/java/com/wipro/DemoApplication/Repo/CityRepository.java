package com.wipro.DemoApplication.Repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CityRepository {
  
  public List<String> getCities() {
    return Arrays.asList("Mumbai", "Delhi", "Bangalore", "Chennai", "Hyderabad", "Kolkata");
  }
}
