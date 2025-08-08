package com.wipro.datetimedemo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Date1 {
    public static void main(String[] args) {
        LocalDate dat=LocalDate.of(2023, 11, 1);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String res=dat.format(formatter);
        System.out.println(res); 
    }
}
