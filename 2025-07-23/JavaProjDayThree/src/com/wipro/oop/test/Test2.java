package com.wipro.oop.test;

import com.wipro.oop.*;

public class Test2 {
    public static void main(String[] args) {
        PaymentMethod p;
        p=new Gpay();
        p.pay(300);
        p=new PhonePay();
        p.pay(1000);
    }
}
