package com.wipro.annonymous.test;
import java.util.function.Predicate;
public class Predicate1 {
    public static void main(String[] args) {
        Predicate<String> isPalindrome=str->{
        String var1=str.toLowerCase();
        return var1.equals(new StringBuilder(var1).reverse().toString());
        };
        System.out.println(isPalindrome.test("madam"));
    }
}
