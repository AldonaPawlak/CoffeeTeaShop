package com.codecool.coffeeteashop;

import com.codecool.coffeeteashop.controller.AdminMenuController;
import com.codecool.coffeeteashop.controller.DAO.ProductCategoryDAO;
import com.codecool.coffeeteashop.controller.DAO.ProductDAO;
import com.codecool.coffeeteashop.controller.DAO.UserDAO;
import com.codecool.coffeeteashop.controller.Login;
import com.codecool.coffeeteashop.controller.MenuController;
import com.codecool.coffeeteashop.controller.Registration;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

import java.util.Arrays;

public class Program {
    private Input input = new Input();
    private UI ui = new UI();
    private UserDAO userDAO = new UserDAO();
    private ProductDAO productDAO = new ProductDAO();
    private ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();
    private AdminMenuController adminMenuController = new AdminMenuController();

    public void runProgram() {
        ui.printMenu();
        int userOption = input.getIntegerInput("Enter option: ");
        switch (userOption){
            case 1:
                Login login = new Login();
                login.loginToDb();
                break;
            case 2:
                ui.print("Registration");
                Registration registration = new Registration(userDAO);
                registration.register();
                break;
            case 0:
                break;
            default:
                ui.print("Wrong option");
                runProgram();
                break;
        }
    }
}
