package com.company;

public class Main {

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal? ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual interest rate?: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years)?: ", 1, 30);

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, years);
        MortgageReport report = new MortgageReport(calculator);
        report.printMonthlyPayment();
        report.printPaymentSchedule();
    }

}
