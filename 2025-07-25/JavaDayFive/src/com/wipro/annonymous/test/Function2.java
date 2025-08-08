package com.wipro.annonymous.test;
import java.util.*;
import java.util.function.Function;
public class Function2 {
    public static void main(String[] args) {
        List<String> l1=Arrays.asList("Raju","Ramesh","Rohan");
         Function<List<String>,List<Integer>> getL=l2->{
            List<Integer> ls=new ArrayList<>();
            for(String str:l2){ls.add(str.length());}
            return ls;
        };
        List<Integer> len=getL.apply(l1);
        System.out.println(len);
    }
}