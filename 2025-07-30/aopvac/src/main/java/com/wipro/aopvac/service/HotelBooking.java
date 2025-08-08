package com.wipro.aopvac.service;
import org.springframework.stereotype.Component; 


@Component
public class HotelBooking {
	
	public void showBookingSlip()
	{
		System.out.println("--showBookingSlip--");
	}
	
	public void showPhotoId()
	{
		System.out.println("--showPhotoId--");
	}
	
	public void pay()
	{
		System.out.println("--pay--");
	}

}
