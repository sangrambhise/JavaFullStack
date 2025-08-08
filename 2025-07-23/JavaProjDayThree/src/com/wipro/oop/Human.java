package com.wipro.oop;

public class Human extends Animal {

    public Human(String name, int age) {
        super(name,age);
    }

    @Override
    public void makesSound() {
        System.out.println(getName()+"says Hi!");
    }
}
