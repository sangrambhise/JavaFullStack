package com.wipro.repo;

import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class CarRepository {
    public List<String> getCarNames() {
        return Arrays.asList("Audi", "Mercedes", "BMW");
    }
}

