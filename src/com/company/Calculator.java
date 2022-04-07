package com.company;

public class Calculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public double calculateMortgage(
            int principal,
            float annualInterestRate,
            byte years
    ) {
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        double mortgage = principal * (
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                ) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        return mortgage;
    }

    public double calculateBalance(
            int principal,
            float annualInterestRate,
            byte years,
            short numberOfPaymentsMade
    ) {
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double balance = principal
                * ( Math.pow(1 + monthlyInterestRate, numberOfPayments)
                - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade) )
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return balance;
    }
}
