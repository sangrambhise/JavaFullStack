package com.wipro.test;
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers=new ArrayList<>();
        numbers.add(0);
        numbers.add(5);
        numbers.add(7);
        numbers.add(21);
        numbers.add(25);
        System.out.println("list"+numbers);
        numbers.remove(2);
        System.out.println("removing index 2 "+numbers);
        numbers.add(30);
        System.out.println("adding 60 "+numbers);
    }
}
