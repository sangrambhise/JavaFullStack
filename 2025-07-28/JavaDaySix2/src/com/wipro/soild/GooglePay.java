package com.wipro.soild;

public class GooglePay implements DigitalPayment{
    public void DigitalPayment(double amount){
        System.out.println("Paid ₹"+amount+" using GooglePay");
    }
}