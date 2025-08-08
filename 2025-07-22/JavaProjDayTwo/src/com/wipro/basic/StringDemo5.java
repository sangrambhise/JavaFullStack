package com.wipro.basic;
import java.util.Arrays;
public class StringDemo5 {

	public static void main(String[] args) {
		String s="Here are your Spectacles";
		int minLen=s.length();
        int start=0, minStart=0;
        
        for(int i=0;i<=s.length();i++) {
            if (i==s.length()||s.charAt(i)==' '){
                int len=i-start;
                if (len>0 && len<minLen){
                    minLen=len;
                    minStart=start;
                }
                start = i + 1;
            }
        }
        
        for(int i=minStart; i<minStart+minLen; i++){
            System.out.print(s.charAt(i));
        }
    }

}
