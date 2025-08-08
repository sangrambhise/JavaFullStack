package com.wipro.collection;
import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> num1 = new ArrayList<>();
        num1.add(10);
        num1.add(20);
        num1.add(10);
        num1.add(30);
        num1.add(20);
        System.out.println(num1);
        Set<Integer> uniqueNum=new HashSet<>(num1);
        List<Integer> noDup=new ArrayList<>(uniqueNum);
        System.out.println(noDup);
    }
}