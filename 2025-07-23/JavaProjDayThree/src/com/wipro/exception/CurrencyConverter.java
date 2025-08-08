package com.wipro.exception;

public class CurrencyConverter {
    public static double changeCurrency(double amount) throws NumberFormatException {
        if (amount==0){
            throw new NumberFormatException("Invalid Number");
        }
        
        return amount*80;
    }

    public static void main(String[] args) {
        double amount=0; 
        
        try {
            double convertedAmount = changeCurrency(amount);
            System.out.println("Converted Amount: "+convertedAmount);
        } catch (NumberFormatException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
