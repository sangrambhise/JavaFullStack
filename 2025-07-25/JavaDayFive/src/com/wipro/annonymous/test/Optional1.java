package com.wipro.annonymous.test;
import java.util.Optional;
public class Optional1 {
	    public static void main(String[] args) {
	        Optional<Integer> optionalInt=Optional.of(22);
	        optionalInt.ifPresent(value->System.out.println(value));
	        Optional<String> optionalString=Optional.empty();
	        String result=optionalString.orElse("Default Value");
	        System.out.println(result);
	    }
	}

