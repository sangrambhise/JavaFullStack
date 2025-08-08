package com.wipro.relationaldemo.controller;

import com.wipro.relationaldemo.entity.Employee;
import com.wipro.relationaldemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    
    
    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        return employeeService.getEmployeeById(id).orElse(null);
    }
}

