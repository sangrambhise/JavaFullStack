package com.wipro.collection;
import java.util.Comparator;
public class SortByEmpId implements Comparator<Employee>{
    public int compare(Employee e1,Employee e2){
        return e1.EID.compareTo(e2.EID);
    }
}

