package com.wipro.annonymous.test;
import com.wipro.annonymous.BankOps;
public class BankDemo {
    public static void main(String[] args) {
        BankOps savings=new BankOps() {
            private double bal=0.0;
            @Override
            public void deposit(double amt) {
                bal+=amt;
                System.out.println("Savings Deposit "+amt+" New Bal"+bal);
            }
        };
        BankOps current=new BankOps() {
            private double bal=0.0;
            @Override
            public void deposit(double amt) {
                bal+=amt;
                System.out.println("Current Deposit "+amt+" New Bal "+bal);
            }
        };
        savings.deposit(5000);
        current.deposit(10000);
    }
}

