package com.wipro.basic;

public class StringDemo {

	public static void main(String[] args) {
		String a="madam";
		boolean palindrome = true;
		for (int i = 0; i < (a.length()) / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length() - i - 1)) {
                palindrome = false;
                break;
            }
        }
		if (palindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
		

	}

}
