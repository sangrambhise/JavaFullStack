package com.wipro.annonymous.test;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.function.Supplier;

public class Datefind {
    public static void main(String[] args) {
    	  Supplier<String>tomDay=()->{
              LocalDate tom=LocalDate.now().plusDays(1);
              DateTimeFormatter formatter=DateTimeFormatter.ofPattern("EEEE");
              return tom.format(formatter);
          };
          System.out.println(tomDay.get());
      }
}
