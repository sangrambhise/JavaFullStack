package com.wipro.datetimedemo;
import java.time.LocalDate;
import java.time.Period;
public class Date2{
	public static int getAge(LocalDate birthDate) {
	    LocalDate today=LocalDate.now();
	    return today.getYear()-birthDate.getYear();
	}
public static void main(String[] args) {
    LocalDate dt11=LocalDate.of(1990, 1, 10);
    System.out.println("Age is"+getAge(dt11));
}

}