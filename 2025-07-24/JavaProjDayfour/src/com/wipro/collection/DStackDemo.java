package com.wipro.collection;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DStackDemo {
    public static void main(String[] args) {
        Queue<Integer> line = new PriorityQueue<>(Collections.reverseOrder());
        line.add(12);
        line.add(21);
        line.add(3);
        line.add(63);
        line.add(45);
        line.add(1);

        System.out.println("After adding first set of elements: " + line);
        
        line.add(67);
        System.out.println("After adding 67: " + line);
        
        line.add(11);
        System.out.println("After adding 11: " + line);
    }
}
