package com.wipro.basic;
import java.util.Arrays;
public class StringDemo4 {

	public static void main(String[] args) {
		String str1="listen";
        String str2="silent";
        if (str1.length()!= str2.length()) {
            System.out.println("Not Anagram");
            return;
        }
        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean isAnagram = true;
        for (int i=0;i<arr1.length;i++) {
            if (arr1[i] != arr2[i]) {
                isAnagram = false;
                break;
            }
        }
        if (isAnagram) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }
	}

}
