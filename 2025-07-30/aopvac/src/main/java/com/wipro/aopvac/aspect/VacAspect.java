package com.wipro.aopvac.aspect;

import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
@Component
public class VacAspect {
	
	 	
//	@After("execution(* com.wipro.aopvac.service..showBookingSlip(..))")
//	void showVacCard(JoinPoint jp)
//	{
//		System.out.println("--Show Vaccination card");
//		
//	}
//	
	@Before("execution(* com.wipro.aopvac.service..*(..))")
	void wearMask(JoinPoint jp)
	{
		System.out.println("--wearMask--");
		
	}
	
	 
	
	

}
