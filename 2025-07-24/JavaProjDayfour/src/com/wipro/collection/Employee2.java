package com.wipro.collection;

public class Employee2 {
    String empId;
    String empName;
    int empAge;
    double empSalary;
    public Employee2(String empId,String empName,int empAge,double empSalary) {
        this.empId=empId;
        this.empName=empName;
        this.empAge=empAge;
        this.empSalary=empSalary;
    }
    @Override
    public String toString() {
        return empId+" - "+empName+" - "+empAge+" - "+empSalary;
    }
}
