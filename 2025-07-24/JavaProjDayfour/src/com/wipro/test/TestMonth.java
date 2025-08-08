package com.wipro.test;

import com.wipro.exception.InvalidMonthException;
import com.wipro.exception.MonthChecker;

public class TestMonth {
    public static void main(String[] args) {
        int[] testMonths = {6,0,13,10};

        for (int month:testMonths) {
            try {
                MonthChecker.checkMonth(month);
            } catch (InvalidMonthException e) {
                System.out.println("Exception caught: "+e.getMessage());
            }
        }
    }
}