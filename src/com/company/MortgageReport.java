package com.company;

import java.text.NumberFormat;

public class MortgageReport {
    public static void printMonthlyPayment(int principal, float annualInterestRate, byte years) {
        double monthlyPayment = calculateMortgage(principal, annualInterestRate, years);
        String monthlyPaymentFormatted = Main.formatCurrency(monthlyPayment);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payment: " + monthlyPaymentFormatted);
    }

    public static void printPaymentSchedule(int principal, float annualInterestRate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * Main.MONTHS_IN_YEAR; month++) {
            double balance = Main.calculateBalance(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double calculateMortgage(
            int principal,
            float annualInterestRate,
            byte years
    ) {
        float monthlyInterestRate = annualInterestRate / Main.MONTHS_IN_YEAR / Main.PERCENT;
        short numberOfPayments = (short)(years * Main.MONTHS_IN_YEAR);
        double mortgage = principal * (
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                ) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        return mortgage;
    }
}
