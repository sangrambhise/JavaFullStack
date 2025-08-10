package com.wipro.soild;
public class Paytm implements DigitalPayment {
    @Override
    public void DigitalPayment(double amount) {
        System.out.println("Paid ₹"+amount+" using Paytm");
    }
}