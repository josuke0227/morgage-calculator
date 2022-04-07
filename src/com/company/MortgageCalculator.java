package com.company;

public class MortgageCalculator {
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterestRate = annualInterest / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        double mortgage = principal * (
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                ) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        return mortgage;
    }

    public double calculateBalance(
            short numberOfPaymentsMade
    ) {
        float monthlyInterestRate = annualInterest / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double balance = principal
                * ( Math.pow(1 + monthlyInterestRate, numberOfPayments)
                - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade) )
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return balance;
    }

    public short getYears() {
        return years;
    }
}
