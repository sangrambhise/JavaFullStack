package com.wipro.collection;
import java.util.*;

import java.util.*;

public class Currency {
    public static void main(String[] args) {
        Map<String, String> currencyMap = new TreeMap<>();
        currencyMap.put("USD", "United States Dollar");
        currencyMap.put("EUR", "Euro");
        currencyMap.put("INR", "Indian Rupee");
        List<String> codes = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (String code : currencyMap.keySet()) {
            codes.add(code);
            names.add(currencyMap.get(code));
        }
        Collections.sort(names);
        for (String name : names) {
            for (String code : codes) {
                if (currencyMap.get(code).equals(name)) {
                    System.out.println(code + " - " + name);
                    codes.remove(code);
                    break;
                }
            }
        }
    }
}