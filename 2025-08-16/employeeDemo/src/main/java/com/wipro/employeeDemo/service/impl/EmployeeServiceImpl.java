package com.wipro.employeeDemo.service.impl;

import com.wipro.employeeDemo.entity.Employee;
import com.wipro.employeeDemo.repo.EmployeeRepository;
import com.wipro.employeeDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    @Override
    public Employee save(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee existing = getById(id);
        existing.setName(employee.getName());
        existing.setType(employee.getType());
        existing.setAddress(employee.getAddress());
        existing.setDepartment(employee.getDepartment());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Employee> searchByName(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Employee> search(String keyword) {
        return searchByName(keyword);
    }
    
}
