package com.wipro.employeeDemo.service;

import java.util.List;
import com.wipro.employeeDemo.entity.Department;

public interface DepartmentService {
    List<Department> getAll();
    Department getById(Long id);
}
