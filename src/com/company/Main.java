package com.company;

import java.text.NumberFormat;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal? ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual interest rate?: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years)?: ", 1, 30);

        MortgageReport.printMonthlyPayment(principal, annualInterestRate, years);
        MortgageReport.printPaymentSchedule(principal, annualInterestRate, years);
    }

    public static double calculateBalance(
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

    public static String formatCurrency(double amount) {
        String result = NumberFormat.getCurrencyInstance().format(amount);
        return result;
    }
}
