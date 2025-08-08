package com.wipro.soild;

public class Process{
    private DigitalPayment paymentMethod;

    public Process(DigitalPayment paymentMethod){
        this.paymentMethod=paymentMethod;
    }
    public void processPayment(double amount){
        paymentMethod.DigitalPayment(amount);
    }
}