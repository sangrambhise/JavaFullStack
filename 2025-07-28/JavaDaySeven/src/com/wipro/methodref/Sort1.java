package com.wipro.methodref;
	import java.util.Arrays;
	import java.util.List;
	import java.util.stream.Collectors;
	import java.util.*;
public class Sort1 {
	    public static void main(String[] args) {
	        List<String> l1=Arrays.asList("Ramesh","Ritik","Raju","Champak","Viru");
	        List<String> res=l1.stream()
//	        			.map(StringUtils::capitalize)
	                .sorted(String::compareTo)
	                .collect(Collectors.toList());
	        res.forEach(System.out::println);
	}
}
