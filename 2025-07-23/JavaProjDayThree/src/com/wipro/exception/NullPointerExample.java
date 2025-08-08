package com.wipro.exception;
public class NullPointerExample {
    public static void main(String[] args) {
        String fName=null;
        try {
        	String uName = fName.toUpperCase();
            System.out.println(uName);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException!");
            System.out.println("Cannot call method");
        }
    }
}
