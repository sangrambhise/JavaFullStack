package com.wipro.basic;

public class ShapesTwo {
    public static void main(String[] args) {
        char shape = 'C';

        switch (shape) {
            case 'R':
                System.out.println("Rectangle");
                break;
            case 'C':
                System.out.println("Circle");
                break;
            case 'S':
                System.out.println("Square");
                break;
            default:
                System.out.println("Other");
                break;
        }
    }
}