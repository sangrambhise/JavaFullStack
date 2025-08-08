package com.wipro.soild;
public class PhonePe implements DigitalPayment{
    @Override
    public void DigitalPayment(double amount){
        System.out.println("Paid ₹"+amount+" using PhonePe");
    }
}