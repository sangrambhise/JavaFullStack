package com.wipro.basic;

public class StringDemo2 {

	public static void main(String[] args) {
		String a="madam";
        String reversed=new StringBuilder(a).reverse().toString();
        if (a.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

	}

}
