package com.wipro.employeeDemo.controller;

import com.wipro.employeeDemo.entity.Department;
import com.wipro.employeeDemo.entity.Employee;
import com.wipro.employeeDemo.service.DepartmentService;
import com.wipro.employeeDemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "listEmployees";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAll());
        return "addEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        loadDepartmentEntity(employee);
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee emp = employeeService.getById(id);
        model.addAttribute("employee", emp);
        model.addAttribute("departments", departmentService.getAll());
        return "addEmployee";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        loadDepartmentEntity(employee);
        employeeService.update(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/search")
    public String searchEmployees(@RequestParam String keyword, Model model) {
        List<Employee> employees;
        try {
            Long id = Long.parseLong(keyword);
            employees = Collections.singletonList(employeeService.getById(id));
        } catch (NumberFormatException ex) {
            employees = employeeService.searchByName(keyword);
        }
        model.addAttribute("employees", employees);
        return "listEmployees";
    }

    private void loadDepartmentEntity(Employee employee) {
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department dept = departmentService.getById(employee.getDepartment().getId());
            employee.setDepartment(dept);
        }
    }
}
