package com.wipro.oop;

public class HDFC implements BankOps {
    private double balance = 0.0;

    @Override
    public void deposit(double amount,String accNumber) {
        balance += amount;
        System.out.println("HDFC: Deposited ₹"+amount +" into account " + accNumber);
    }

    @Override
    public double withdraw(double amount, String accNumber) {
        if (amount<=balance) {
            balance-=amount;
            System.out.println("HDFC Withdrew " +amount+" from account "+accNumber);
        } else {
            System.out.println("HDFC Insufficient funds"+accNumber);
        }
        return balance;
    }
}
