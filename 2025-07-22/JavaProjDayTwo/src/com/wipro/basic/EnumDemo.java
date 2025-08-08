package com.wipro.basic;

public class EnumDemo {
	enum Month {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER
    }
	public static void main(String[] args) {
        for (Month m : Month.values()) {
            System.out.println(m);
        }
        Month month = Month.FEBRUARY;
        if (month == Month.FEBRUARY) {
            System.out.println("month is February");
        } else {
            System.out.println("month not February");
        }
	}
}
