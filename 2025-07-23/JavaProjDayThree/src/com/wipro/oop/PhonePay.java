package com.wipro.oop;

public class PhonePay implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("PhonePay "+amount);
    }
}
