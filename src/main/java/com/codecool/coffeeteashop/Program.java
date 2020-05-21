package com.codecool.coffeeteashop;

import com.codecool.coffeeteashop.controller.AdminMenuController;
import com.codecool.coffeeteashop.controller.DAO.ProductCategoryDAO;
import com.codecool.coffeeteashop.controller.DAO.ProductDAO;
import com.codecool.coffeeteashop.controller.DAO.UserDAO;
import com.codecool.coffeeteashop.controller.Login;
import com.codecool.coffeeteashop.controller.Registration;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

import java.io.IOException;

public class Program {
    private Input input = new Input();
    private UI ui = new UI();
    private UserDAO userDAO = new UserDAO();
    private ProductDAO productDAO = new ProductDAO();
    private ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();
    private AdminMenuController adminMenuController = new AdminMenuController();

    public void runProgram() throws IOException {
        ui.printMenu();
        boolean isRunning = true;
        while (isRunning) {
            int userOption = input.getNumericInput("Enter option: ", 0, 3);
            if(userOption == 0) {
                isRunning = false;
            }
            switch (userOption) {
                case 1: {
                    Login login = new Login();
                    login.loginToDb(this);
                    isRunning = false;
                    break;
                }
                case 2: {
                    ui.print("\nRegistration\n");
                    Registration registration = new Registration(userDAO);
                    registration.register(this, ui);

                    break;
                }
                case 0: {
                    ui.print("\nThank you for visiting our shop.\n");
                    break;
                }
                default: {
                    ui.print("Wrong option");
                    runProgram();
                    break;
                }
            }
        }
    }

}
