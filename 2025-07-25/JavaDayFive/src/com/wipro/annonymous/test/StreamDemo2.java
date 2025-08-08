package com.wipro.annonymous.test;
import java.util.*;
public class StreamDemo2 {
    public static void main(String[] args) {
    	List<Integer> l1=Arrays.asList(9,1,0,4,5);
        int sum=l1.stream()
                .reduce(0,(a,b)->a+b);
        long count=l1.stream().count();
        System.out.println(sum/count);
    }
    }

