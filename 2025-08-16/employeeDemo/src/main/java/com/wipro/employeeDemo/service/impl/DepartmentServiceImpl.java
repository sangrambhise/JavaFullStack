package com.wipro.employeeDemo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.employeeDemo.entity.Department;
import com.wipro.employeeDemo.repo.DepartmentRepository;
import com.wipro.employeeDemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    @Override
    public List<Department> getAll() {
        return repo.findAll();
    }

    @Override
    public Department getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }
}

