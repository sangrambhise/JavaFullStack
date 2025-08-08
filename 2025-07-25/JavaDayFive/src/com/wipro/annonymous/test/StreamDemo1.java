package com.wipro.annonymous.test;
import java.util.*;
import java.util.stream.Collectors;
public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> l1=Arrays.asList("Jayanta","Champak","Janardhan","Raja","Ramesh");
        List<String>l2=l1.stream()
                .filter(name1->name1.contains("ja")||name1.contains("Ja"))
                .collect(Collectors.toList());
        System.out.println(l2);
    }
}
