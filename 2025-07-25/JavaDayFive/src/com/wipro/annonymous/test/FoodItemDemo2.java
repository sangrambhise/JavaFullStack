package com.wipro.annonymous.test;
import java.util.*;

import com.wipro.annonymous.FoodItem;
public class FoodItemDemo2 {
    public static void main(String[] args) {
        FoodItem f1=new FoodItem("Spring Rolls","Veg","Chinese",150);
        FoodItem f2=new FoodItem("Fried Rice","Non-Veg","Chinese",250);
        FoodItem f3=new FoodItem("Paneer Butter Masala","Veg","Indian",200);
        FoodItem f4=new FoodItem("Chicken","Non-Veg","Chinese",300);
        List<FoodItem> l1=Arrays.asList(f1,f2,f3,f4);
        FoodItem o1=l1.stream()
        		.filter(f -> f.getCuisine().equals("Chinese"))
                .reduce((a1,a2)->a1.getPrice()>a2.getPrice()?a1:a2)
                .orElse(null);
        System.out.println(o1);

    }
}