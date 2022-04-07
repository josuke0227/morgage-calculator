package com.company;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNubmer(String prompt){
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;

        while(true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between" + min + " and " + max);
        }
        return value;
    }
}
