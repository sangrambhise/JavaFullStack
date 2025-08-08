package com.wipro.aopvac.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RestaurantAspect {

	@Around("execution(* com.wipro.aopvac.service.RestaurantService.eat())")
	void washHand(ProceedingJoinPoint  jp)
	{
		System.out.println("--Wash your hand--");
		try {
			jp.proceed();
			System.out.println("--Wash your hand--");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterThrowing(pointcut="execution(* com.wipro.aopvac.service.RestaurantService.takeFood())", throwing="ex")
	void informRestaurnatManager(JoinPoint jp,Throwable ex)
	{
		System.out.println("Call Restaurant Manager");
	}
	
}
