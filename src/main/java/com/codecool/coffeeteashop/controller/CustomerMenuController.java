package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.ProductDAO;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

import java.io.IOException;

public class CustomerMenuController {
    UI ui = new UI();
    Input input = new Input();

    public CustomerMenuController() {
    }

    public void userOptions() throws IOException {
        ui.printUserMenu();
        final int userChoice = input.getIntegerInput("What do you want to do right now?\n");
        switch (userChoice) {
            case 1: {

                break;
            }
        }
    }

    private void showSpecificCategory() throws IOException {
        String category = input.getStringInput("Which category you want to show?\n").toLowerCase();
        int categoryId = getCategoryId(category);
        ProductDAO productDAO = new ProductDAO();
        productDAO.selectSpecificCategory(categoryId);
    }

    private int getCategoryId(String categoryName){
        if (categoryName.equals("coffee")){
            return 1;
        }
        else if (categoryName.equals("tea")){
            return 2;
        }
        else if (categoryName.equals("sugar")){
            return 3;
        }
        else if (categoryName.equals("coffee cups")){
            return 4;
        }
        else if (categoryName.equals("chocolate")){
            return 5;
        }

        return 1;
    }

}