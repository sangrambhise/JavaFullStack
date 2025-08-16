package com.wipro.employeeDemo.service;

import java.util.List;

import com.wipro.employeeDemo.entity.Employee;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> getAll();
    Employee getById(Long id);
    Employee update(Long id, Employee employee);
    void delete(Long id);
    List<Employee> search(String keyword);
    List<Employee> searchByName(String keyword);
}
