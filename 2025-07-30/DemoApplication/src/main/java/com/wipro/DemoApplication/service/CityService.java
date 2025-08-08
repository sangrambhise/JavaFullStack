package com.wipro.DemoApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.DemoApplication.Repo.CityRepository;

@Service
public class CityService {

  @Autowired
  private CityRepository cityRepository;

  public List<String> fetchCities() {
    return cityRepository.getCities();
  }
}
