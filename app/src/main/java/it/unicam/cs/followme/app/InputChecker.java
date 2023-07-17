package it.unicam.cs.followme.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputChecker {
    private final Scanner scanner;

    public InputChecker() {this.scanner = new Scanner(System.in);}
    public int checkInput() {
        int result = 0;

        while (result <= 0)
        try {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
            } else {
                scanner.next();
            }
        } catch (
                InputMismatchException e) {
            scanner.next();
        }
        this.scanner.close();

        return result;
    }

}
