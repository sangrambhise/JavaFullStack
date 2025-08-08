package com.wipro.collection;
import java.util.Comparator;
public class SortByEmpName implements Comparator<Employee>{
    public int compare(Employee e1,Employee e2){
        return e1.ENAME.compareTo(e2.ENAME);
    }
}

