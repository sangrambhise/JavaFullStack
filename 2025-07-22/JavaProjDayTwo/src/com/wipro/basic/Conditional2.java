package com.wipro.basic;

public class Conditional2 {

	public static void main(String[] args) {
		float num=-5;
		if(num==0.0) {
			System.out.println("zero");
		}
		else if (num>0) {
			System.out.println("positive");
			if((Math.abs(num))<1) {
				System.out.println("small");
			}
			else if((Math.abs(num))>1000000) {
				System.out.println("large");
			}
			
		}
		else if (num<0) {
			System.out.println("negative");
			if((Math.abs(num))<1) {
				System.out.println("small");
			}
			else if((Math.abs(num))>1000000) {
				System.out.println("large");
			}
		}


	}

}
