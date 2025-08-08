package com.wipro.annonymous.test;
import java.util.*;
import java.util.stream.*;
import com.wipro.annonymous.FoodItem;
public class FoodItemDemo {
    public static void main(String[] args) {
        FoodItem f1=new FoodItem("Spring Rolls","Veg","Chinese",150);
        FoodItem f2=new FoodItem("Fried Rice","Non-Veg","Chinese",250);
        FoodItem f3=new FoodItem("Paneer Butter Masala","Veg","Indian",200);
        FoodItem f4=new FoodItem("Chicken","Non-Veg","Chinese",300);
        List<FoodItem> l1=Arrays.asList(f1,f2,f3,f4);
        List<FoodItem> chinese = l1.stream()
        	    .filter(f -> f.getCuisine().equals("Chinese"))
        	    .peek(System.out::println)
        	    .collect(Collectors.toList());
    }
}