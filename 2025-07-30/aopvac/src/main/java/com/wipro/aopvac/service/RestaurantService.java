package com.wipro.aopvac.service;

import org.springframework.stereotype.Component;

import com.wipro.aopvac.exception.OutOfFoodException;

@Component
public class RestaurantService {
	
	public void eat()
	{
		System.out.println("--eating Food--");
	}

	
	public void takeFood() throws OutOfFoodException
	{
		throw new OutOfFoodException("No Food");
		
	}
}
