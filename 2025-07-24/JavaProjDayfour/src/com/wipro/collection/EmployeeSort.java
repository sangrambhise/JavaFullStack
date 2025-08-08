package com.wipro.collection;
import java.util.*;
public class EmployeeSort {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("E103", "Alice", 30));
        employees.add(new Employee("E101", "Bob", 25));
        employees.add(new Employee("E104", "Charlie", 35));
        employees.add(new Employee("E102", "David", 28));
        Collections.sort(employees, new SortByEmpId());
        System.out.println("Sorted by empId:");
        for (Employee e : employees) {
            System.out.println(e);
        }
        System.out.println();
        Collections.sort(employees, new SortByEmpName());
        System.out.println("Sorted by empName:");
        for (Employee e : employees) {
            System.out.println(e);
        }
        System.out.println();
        Collections.sort(employees, new SortByEmpAge());
        System.out.println("Sorted by empAge:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
