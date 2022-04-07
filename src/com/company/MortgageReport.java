package com.company;

import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (double balance : calculator.getRemainingBalances())
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
    }

    public void printMonthlyPayment() {
        double monthlyPayment = calculator.calculateMortgage();
        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payment: " + monthlyPaymentFormatted);
    }
}
