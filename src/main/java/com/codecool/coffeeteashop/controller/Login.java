package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.Program;
import com.codecool.coffeeteashop.controller.DAO.UserDAO;
import com.codecool.coffeeteashop.model.User;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

import java.io.IOException;

public class Login {


    private Input input = new Input();
    private UI ui = new UI();
    private User user;

    public void loginToDb(Program program) throws IOException {
        UserDAO userDao = new UserDAO();
        user = userDao.selectUser();
        if (user == null) {
            System.out.println("\n\nYou have to register first\n\n");
        }

        user.displayMenuOptions();

//        if (user.isCustomer()){
//        if (user.getRights().matches("customer")) {
//            System.out.println("\nYou might do shopping\n");
//            CustomerMenuController customerMenuController = new CustomerMenuController(user);
//
//            customerMenuController.userOptions();
//        }
//        if (user.isAdmin()) {
//            AdminMenuController adminMenuController = new AdminMenuController();
//            adminMenuController.adminOptions();
//        }
//        program.runProgram();

    }
}

