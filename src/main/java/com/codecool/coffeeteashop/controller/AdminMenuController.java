package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.ProductCategoryDAO;
import com.codecool.coffeeteashop.controller.DAO.ProductDAO;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

public class AdminMenuController {
    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();
    ProductDAO productDAO = new ProductDAO();
    UI ui = new UI();
    Input input = new Input();

    public void adminOptions() { // shoud be used in case someone will register as admin
        ui.printAdminMenu();
        final int adminChoice = input.getIntegerInput("What do you want to do right now?");
        switch (adminChoice) {
            case 1: {
                ui.print("ADDING THE NEW PRODUCT CATEGORY");
                productCategoryDAO.insertInto();
                break;
            }
            case 2: {
                ui.print("EDITING NAME OF PRODUCT CATEGORY");
                productCategoryDAO.update();
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                ui.print("ADDING THE NEW PRODUCT");
                productDAO.insertInto();
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                ui.print("Deactivate product");
                productDAO.delete();
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                break;
            }
        }
    }

}