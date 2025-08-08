package com.wipro.annonymous.test;
import com.wipro.annonymous.Employee;
import java.util.*;
public class Comparator1 {
    public static void main(String[] args) {
        List<Employee> emps=new ArrayList<>();
        emps.add(new Employee(11,"Mohit",5000));
        emps.add(new Employee(14,"Raju",39000));
        emps.add(new Employee(13,"Ramesh",6000));
        emps.add(new Employee(19,"Rohan",90000));
        Comparator<Employee> sortBySalary=(e1,e2) ->Double.compare(e1.getSalary(),e2.getSalary());
        Collections.sort(emps,sortBySalary);
        System.out.println(emps);
    }
}