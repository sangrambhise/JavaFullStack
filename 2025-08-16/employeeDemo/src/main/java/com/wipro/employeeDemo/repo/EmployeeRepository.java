package com.wipro.employeeDemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.employeeDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);

}
