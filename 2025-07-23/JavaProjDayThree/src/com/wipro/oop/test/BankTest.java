package com.wipro.oop.test;

import com.wipro.oop.BankOps;
import com.wipro.oop.HDFC;
import com.wipro.oop.Citi;

public class BankTest {
    public static void main(String[] args) {
        BankOps hdfc=new HDFC();
        BankOps citi=new Citi();
        hdfc.deposit(5000,"HDFC_abc");
        double hdfcBalance=hdfc.withdraw(2000, "HDFC_abc");
        System.out.println("HDFC Final Balance: ₹"+hdfcBalance);
        citi.deposit(3000,"CITI_def");
        double citiBalance=citi.withdraw(1500, "CITI_def");
        System.out.println("Citi Final Balance: ₹"+citiBalance);
    }
}
