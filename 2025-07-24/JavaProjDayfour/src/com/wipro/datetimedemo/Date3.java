package com.wipro.datetimedemo;
import java.time.LocalDate;
public class Date3 {
	 public static void getDateDiff(LocalDate dt1, LocalDate dt2) {
	        if (dt1.isAfter(dt2)){
	            LocalDate temp=dt1;
	            dt1=dt2;
	            dt2=temp;
	        }
	        int year1=dt1.getYear();
	        int month1 = dt1.getMonthValue();
	        int day1 = dt1.getDayOfMonth();
	        int year2 = dt2.getYear();
	        int month2 = dt2.getMonthValue();
	        int day2 = dt2.getDayOfMonth();
	        
	        int diffYear=year2-year1;
	        int diffMonth=month2-month1;
	        int diffDay=day2-day1;

	        if (diffDay < 0) {
	            diffMonth=diffMonth-1;
	            diffDay=diffDay+30;
	        }

	        if (diffMonth<0){
	            diffYear=diffYear-1;
	            diffMonth=diffMonth+12;
	        }

	        System.out.println("Difference is " +diffYear+" years, "+diffMonth+" months and "+diffDay+" days");
	    }

	    public static void main(String[] args) {
	        LocalDate date1 = LocalDate.of(2024, 12, 25);
	        LocalDate date2 = LocalDate.of(2025, 01, 06);
	        getDateDiff(date1, date2);
	    }
}
