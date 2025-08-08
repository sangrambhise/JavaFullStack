package com.wipro.datetimedemo;
import java.time.LocalDate;
public class Date4 {
	    public static boolean isLeapYear(LocalDate dt) {
	        int year=dt.getYear();
	        if ((year%4==0&&year%100!=0)||(year%400==0)){
	            return true;
	        } else {
	            return false;
	        }
	    }
	    public static void main(String[] args) {
	        LocalDate dat1=LocalDate.of(2025,07, 01);
	        System.out.println(isLeapYear(dat1));
	    }
}
