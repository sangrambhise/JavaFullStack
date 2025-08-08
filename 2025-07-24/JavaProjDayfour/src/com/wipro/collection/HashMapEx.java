package com.wipro.collection;
import java.util.HashMap;
public class HashMapEx {
    public static void main(String[] args) {
        HashMap<String, String> map=new HashMap<>();  
        map.put("HAM","Mumbai");
        map.put("ABIM", "Kolkata");
        map.put("SBIB","Chennai");
        System.out.println(map.get("HAM"));
        map.remove("SBIB");
        System.out.println(map.containsKey("Mumbai"));
    }
}