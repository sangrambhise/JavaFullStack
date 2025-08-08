package com.wipro.annonymous.test;
import java.util.function.Function;
public class Function1 {
    public static void main(String[] args) {
    	 Function<Double, String> find=num->{
             String[] num1=String.valueOf(num).split("\\.");
             if(num1.length>1) {
                 return num1[1];
             } else {
                 return "0";
             }
         };
        double num1=32.795;
        String frac=find.apply(num1);
        System.out.println(frac);
    }
}