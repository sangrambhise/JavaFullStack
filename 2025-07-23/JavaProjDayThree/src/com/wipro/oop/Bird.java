package com.wipro.oop;

public class Bird extends Animal {
    public Bird(String name, int age) {
        super(name,age);
    }
    @Override
    public void makesSound() {
        System.out.println(getName()+" chirps");
    }
}
