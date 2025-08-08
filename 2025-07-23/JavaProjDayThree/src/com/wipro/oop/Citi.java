package com.wipro.oop;

public class Citi implements BankOps {
    private double balance=1000.0;

    @Override
    public void deposit(double amount,String accNumber) {
        balance+=amount;
        System.out.println("Citi: Deposited ₹" +amount+" into account " + accNumber);
    }

    @Override
    public double withdraw(double amount, String accNumber) {
        if (amount<=balance) {
            balance-=amount;
            System.out.println("Citi Withdrew"+amount+" from account "+accNumber);
        } else {
            System.out.println("Citi Insufficient funds"+accNumber);
        }
        return balance;
    }
}
