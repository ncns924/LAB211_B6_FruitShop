
package controller;

import java.util.Scanner;

public class Validation {

    private static Scanner scanner = new Scanner(System.in);

    public double validateDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid decimal number.");
            }
        }
    }

    public int validateIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
