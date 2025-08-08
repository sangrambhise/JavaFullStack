package com.wipro.aopvac;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.aopvac.exception.OutOfFoodException;
import com.wipro.aopvac.service.HotelBooking;
import com.wipro.aopvac.service.RestaurantService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  
    {
        AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
    	ctx.scan("com.wipro.aopvac.*");
    	ctx.refresh();
//    	HotelBooking hotelBooking=ctx.getBean(HotelBooking.class);
//    	hotelBooking.showBookingSlip();
//    	hotelBooking.showPhotoId();
//    	hotelBooking.pay();
    	RestaurantService restaurantService=ctx.getBean(RestaurantService.class);
//    	restaurantService.eat();
    	
    	try {
			restaurantService.takeFood();
		} catch (OutOfFoodException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
    
    	
    }
}
