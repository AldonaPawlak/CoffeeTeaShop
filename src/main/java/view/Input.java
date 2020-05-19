package view;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String getStringInput(String message) {
        System.out.print(message);
        String input = scanner.next();
        if (input.equals(null) || input.equals(" ")){
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
