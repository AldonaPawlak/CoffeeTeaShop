package view;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);

    public String getStringInput(String message) {
        System.out.print(message);
        String input = scanner.next();
        if (input == null || input.equals(" ")){
            System.out.println("Something went wrong. Try again");
            System.out.print(message);
            input = scanner.next();
        }
        return input;
    }

    public int getIntegerInput(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
}
