package com.wipro.annonymous.test;
import java.util.function.Consumer;
public class Number{
    public static void main(String[] args){
        Consumer<Integer> nEven=num1->{
            int nex=(num1%2==0)?num1+2:num1+1;
            System.out.println(nex);
        };
        nEven.accept(62);
    }
}