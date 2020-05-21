package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.ProductCategoryDAO;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

public class AdminMenuController {
    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();
    UI ui = new UI();
    Input input = new Input();

    public void adminOptions() {
        ui.printAdminMenu();
        final int adminChoice = input.getIntegerInput("What do you want to do right now?");
        switch (adminChoice) {
            case 1: {
                break;
            }
        }
    }

    public void addNewProductCategory () {
        System.out.println("ADDING THE NEW PRODUCT CATEGORY");
        productCategoryDAO.insertInto();
    }
}
