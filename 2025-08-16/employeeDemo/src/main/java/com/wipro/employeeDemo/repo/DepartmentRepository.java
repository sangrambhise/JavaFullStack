package com.wipro.employeeDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.employeeDemo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

