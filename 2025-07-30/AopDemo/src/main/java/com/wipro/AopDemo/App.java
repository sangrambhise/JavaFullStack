package com.wipro.AopDemo;

import com.wipro.config.AopConfig;
import com.wipro.exception.NoSeatAvailableException;
import com.wipro.process.AirTravelProcess;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AirTravelProcess travel = context.getBean(AirTravelProcess.class);

        try {
            travel.checkIn(false); 
            travel.collectBoardingPass();
            travel.doSecurityCheck();
            travel.doBoarding();
        } catch (NoSeatAvailableException e) {
        }

        context.close();
    }
}