package com.wipro.basic;
import java.util.Arrays;
public class StringDemo3 {

	public static void main(String[] args) {
		String s="listen";
		int v=0, c=0;
        for (int i= 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='a'|| ch=='e'|| ch=='i'||ch=='o'||ch=='u') 
            	v++;
            else if (ch>='a' && ch<='z') 
            	c++;
        }
        System.out.println(v + " " + c);
    }

}
