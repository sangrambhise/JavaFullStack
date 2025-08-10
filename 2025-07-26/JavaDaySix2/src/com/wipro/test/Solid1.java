package com.wipro.test;
import com.wipro.soild.GooglePay;
import com.wipro.soild.DigitalPayment;
import com.wipro.soild.Process;
import com.wipro.soild.Paytm;
import com.wipro.soild.PhonePe;

public class Solid1 {
    public static void main(String[] args) {
        DigitalPayment googlePay=new GooglePay();
        DigitalPayment phonePe=new PhonePe();
        DigitalPayment paytm=new Paytm();
        Process processor1=new Process(googlePay);
        processor1.processPayment(5000);
        Process processor2=new Process(phonePe);
        processor2.processPayment(60000);
        Process processor3=new Process(paytm);
        processor3.processPayment(70000);
    }

}
