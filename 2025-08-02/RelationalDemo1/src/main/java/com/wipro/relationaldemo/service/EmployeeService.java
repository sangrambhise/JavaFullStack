package com.wipro.relationaldemo.service;
import com.wipro.relationaldemo.entity.Employee;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Optional<Employee> getEmployeeById(int id);
}
