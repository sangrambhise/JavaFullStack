package com.wipro.SpringDemo;

public class Department {
    private String deptCode;
    private String departmentName;

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptCode='" + deptCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
