package com.wipro.collection;

import java.util.Comparator;

public class SortByEmpAge implements Comparator<Employee>{
    public int compare(Employee e1,Employee e2){
        return Integer.compare(e1.EAGE, e2.EAGE);
    }
}
