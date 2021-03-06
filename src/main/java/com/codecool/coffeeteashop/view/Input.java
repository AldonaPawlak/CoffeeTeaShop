package com.codecool.coffeeteashop.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Scanner scanner = new Scanner(System.in);

    public String getStringInput(String message) throws IOException {
        System.out.print(message);
        String input = reader.readLine();
        if (input == null || input.equals(" ")){
            System.out.println("Something went wrong. Try again");
            System.out.print(message);
            input = reader.readLine();
        }
        return input;
    }

    public int getIntegerInput(String message) throws IOException {
        System.out.print(message);
        return Integer.parseInt(reader.readLine());
    }

    public int getNumericInput(String title, int from, int to) {
        scanner.useDelimiter(System.lineSeparator());
        String userInput = "";
        System.out.print(title);
        boolean validInput = false;
        while (!validInput) {
            userInput = scanner.next();
            if (isNumericValue(userInput) && isNumberInRange(userInput, from, to)) {
                validInput = true;
            }
        }
        return Integer.parseInt(userInput);
    }

    private static boolean isNumericValue(String userInput) {
        return !userInput.equals("") && userInput.matches("^[0-9]*$");
    }

    private boolean isNumberInRange(String userInput, int from, int to) {
        int option = Integer.parseInt(userInput);
        return option >= from && option < to;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void getEmptyInput() throws IOException {
        System.out.println("Press enter to continue");
        reader.readLine();
    }
}