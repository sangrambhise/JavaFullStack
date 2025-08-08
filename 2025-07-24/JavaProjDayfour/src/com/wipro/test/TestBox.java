package com.wipro.test;
import com.wipro.collection.Box;
public class TestBox {
    public static void main(String[] args) {
        Box<String> stringBox=new Box<>();
        stringBox.set("Hello World");
        System.out.println("String"+stringBox.get());

        Box<Integer> intBox=new Box<>();
        intBox.set(42);
        System.out.println("Integer "+intBox.get());

        Box<Double> doubleBox=new Box<>();
        doubleBox.set(3.14);
        System.out.println("Double"+doubleBox.get());
    }
}
