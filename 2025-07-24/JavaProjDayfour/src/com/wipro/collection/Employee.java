package com.wipro.collection;

public class Employee {
    String EID;
    String ENAME;
    int EAGE;
    public Employee(String EID,String ENAME,int EAGE) {
        this.EID=EID;
        this.ENAME=ENAME;
        this.EAGE=EAGE;
    }
    @Override
    public String toString() {
        return EID+" - "+ENAME+" - Age: "+EAGE;
    }
}