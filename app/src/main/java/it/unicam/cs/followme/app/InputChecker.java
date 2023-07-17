package it.unicam.cs.followme.app;

import java.util.Scanner;

public class InputChecker {
    private final Scanner scanner;

    public InputChecker() {this.scanner = new Scanner(System.in);}
    public int checkInput() {
        int result = 0;

        while (result <= 0)
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        this.scanner.close();

        return result;
    }

}
