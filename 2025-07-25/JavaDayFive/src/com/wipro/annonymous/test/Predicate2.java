package com.wipro.annonymous.test;
import java.util.function.Predicate;
public class Predicate2 {
    public static void main(String[] args) {
        Predicate<String> isUpperCase=str->str.equals(str.toUpperCase());
        Predicate<String> isLowerCase=str->str.equals(str.toLowerCase());
        String str1="HELLO";
        String str2="hello";
        System.out.println(str1+" "+isUpperCase.test(str1));
        System.out.println(str2+" "+isLowerCase.test(str2));
    }
}