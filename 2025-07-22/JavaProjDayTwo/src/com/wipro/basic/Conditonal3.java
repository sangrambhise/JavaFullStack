package com.wipro.basic;

public class Conditonal3 {
	public static void main(String[] args) {
        float num1=95.56598f;
        float num2=95.56545f;
        int n1=(int)(num1*1000);
        int n2=(int)(num2*1000);
        if (n1==n2) {
            System.out.println("They are the same.");
        } else {
            System.out.println("They are different.");
        }

    }
}
