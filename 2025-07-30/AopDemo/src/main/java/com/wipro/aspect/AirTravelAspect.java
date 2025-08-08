package com.wipro.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AirTravelAspect {

    @Before("execution(* com.wipro.process.AirTravelProcess.checkIn(..))")
    public void showPhotoId(JoinPoint jp) {
        System.out.println(" Please show your Photo ID before Check-in.");
    }

    @Before("execution(* com.wipro.process.AirTravelProcess.doSecurityCheck()) || " +
            "execution(* com.wipro.process.AirTravelProcess.doBoarding())")
    public void showBoardingPass(JoinPoint jp) {
        System.out.println("Please show your Boarding Pass.");
    }

    @AfterThrowing(pointcut = "execution(* com.wipro.process.AirTravelProcess.checkIn(..))", throwing = "ex")
    public void handleNoSeatException(JoinPoint jp, Throwable ex) {
        System.out.println(ex.getMessage());
    }
}
