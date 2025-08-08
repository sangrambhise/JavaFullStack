package com.wipro.annonymous.test;
import com.wipro.annonymous.Hi;
public class Demo {
    public static void main(String[] args) {
        Hi greeting=()->System.out.println("Hello");
        greeting.HiGuys();
    }
}
