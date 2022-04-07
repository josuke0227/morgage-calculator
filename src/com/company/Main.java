package com.company;

import java.text.NumberFormat;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal? ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual interest rate?: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years)?: ", 1, 30);

        printMonthlyPayment(principal, annualInterestRate, years);
        printPaymentSchedule(principal, annualInterestRate, years);
    }

    private static void printMonthlyPayment(int principal, float annualInterestRate, byte years) {
        double monthlyPayment = calculateMortgage(principal, annualInterestRate, years);
        String monthlyPaymentFormatted = formatCurrency(monthlyPayment);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payment: " + monthlyPaymentFormatted);
    }

    private static void printPaymentSchedule(int principal, float annualInterestRate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
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

    public static double calculateMortgage(
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

    public static String formatCurrency(double amount) {
        String result = NumberFormat.getCurrencyInstance().format(amount);
        return result;
    }
}
