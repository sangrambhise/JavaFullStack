package com.wipro.SpringDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.wipro.*");
        context.refresh();
        Mobile mobile=context.getBean(Mobile.class);
        System.out.println(mobile);
        context.close();
    }
}
