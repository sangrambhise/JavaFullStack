package com.wipro.exception;

public class MonthChecker {
    public static void checkMonth(int month) throws InvalidMonthException{
        if (month<1||month>12){
            throw new InvalidMonthException("Invalid "+month+"Month must be between 1 and 12.");
        }else{
            System.out.println("Valid "+month);
        }
    }
}