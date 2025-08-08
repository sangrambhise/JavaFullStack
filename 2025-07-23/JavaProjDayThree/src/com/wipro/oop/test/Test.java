package com.wipro.oop.test;
import com.wipro.oop.Converter;
public class Test {
    public static void main(String[] args) {
    	Converter c=new Converter();
        System.out.println(c.convert(100));
        System.out.println(c.convert(10000, 40000));
        System.out.println(c.convert(1.0));
    }
}