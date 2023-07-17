package it.unicam.cs.followme.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputChecker {
    public int checkInput(Scanner scanner) {
        int result = 0;

        while (result <= 0)
            try {
                if (scanner.hasNextInt()) {
                    result = scanner.nextInt();
                } else {
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                scanner.next();
        }

        return result;
    }

}
