package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.Program;
import com.codecool.coffeeteashop.controller.DAO.UserDAO;
import com.codecool.coffeeteashop.model.User;
import com.codecool.coffeeteashop.view.Input;

import java.io.IOException;

public class Login {


    private Input input = new Input();
    private User user;

    public void loginToDb(Program program) throws IOException {
        UserDAO userDao = new UserDAO();
        user = userDao.selectUser();
        if (user == null) {
            System.out.println("You have to register first\n\n");
            program.runProgram();
        }
        if (user.getRights().matches("customer")) {
            System.out.println("\nYou might do shopping");
            CustomerMenuController customerMenuController = new CustomerMenuController();
            customerMenuController.userOptions();
            program.runProgram();
        }
        if (user.getRights().matches("admin")) {
            AdminMenuController adminMenuController = new AdminMenuController();
            adminMenuController.adminOptions();
            program.runProgram();
        }
    }
}

