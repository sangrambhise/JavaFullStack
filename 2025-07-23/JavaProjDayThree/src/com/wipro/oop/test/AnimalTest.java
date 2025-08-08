package com.wipro.oop.test;

import com.wipro.oop.Animal;
import com.wipro.oop.Human;
import com.wipro.oop.Bird;
import com.wipro.oop.Dog;

public class AnimalTest {
    public static void main(String[] args) {
        Animal human=new Human("Rohan", 30);
        Animal bird=new Bird("Parrot",5);
        Animal dog=new Dog("Bruno",12);
        human.eat();
        human.makesSound();
        System.out.println(human);
        bird.eat();
        bird.makesSound();
        System.out.println(bird);
        dog.eat();
        dog.makesSound();
        System.out.println(dog);
    }
}
