package com.wipro.collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class EmployeeSort2 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Employee2> emp = new CopyOnWriteArrayList<>();
        emp.add(new Employee2("E3","Pawan",28,5000));
        emp.add(new Employee2("E1","Rohit",44,8500));
        emp.add(new Employee2("E4","Ramesh",55,95000));
        emp.add(new Employee2("E2","Champak",21,7000));
        for(Employee2 e:emp) {
            System.out.println(e);
        }
        for(Employee2 e : emp) {
            if (e.empSalary>80000) {
                emp.remove(e);
            }
        }
        System.out.println("");
        for(Employee2 e : emp) {
            System.out.println(e);
        }
    }
}