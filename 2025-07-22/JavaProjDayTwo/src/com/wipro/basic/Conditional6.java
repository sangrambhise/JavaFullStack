package com.wipro.basic;

public class Conditional6 {
	public static void main(String[] args) {
		int i=1;
		int num=0;
		while(i<=100) {
			 if (i % 2 == 0) {
	                num = num + i;
	            }
	            i=i+1;
	        }
		System.out.println(num);
	}
	
}
