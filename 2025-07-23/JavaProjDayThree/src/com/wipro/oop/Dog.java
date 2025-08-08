package com.wipro.oop;

public class Dog extends Animal {
    public Dog(String name,int age) {
        super(name,age);
    }
    @Override
    public void makesSound() {
        System.out.println(getName()+" barks");
    }
}
