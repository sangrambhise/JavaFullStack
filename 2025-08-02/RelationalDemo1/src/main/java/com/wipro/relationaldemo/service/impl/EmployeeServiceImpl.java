package com.wipro.relationaldemo.service.impl;

import com.wipro.relationaldemo.entity.Employee;
import com.wipro.relationaldemo.repo.EmployeeRepo;
import com.wipro.relationaldemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepo.findById(id);
    }
}
