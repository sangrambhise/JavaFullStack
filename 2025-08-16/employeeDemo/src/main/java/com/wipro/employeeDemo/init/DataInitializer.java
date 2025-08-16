package com.wipro.employeeDemo.init;


import com.wipro.employeeDemo.entity.Department;
import com.wipro.employeeDemo.repo.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;

    public DataInitializer(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) {
        if (departmentRepository.count() == 0) {
            departmentRepository.save(new Department(null, "HR"));
            departmentRepository.save(new Department(null, "IT"));
            departmentRepository.save(new Department(null, "Finance"));
            departmentRepository.save(new Department(null, "Marketing"));
            departmentRepository.save(new Department(null, "Operations"));
        }
    }
}
