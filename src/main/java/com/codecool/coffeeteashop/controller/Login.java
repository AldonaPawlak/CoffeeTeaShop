package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.UserDAO;
import com.codecool.coffeeteashop.model.User;
import com.codecool.coffeeteashop.view.Input;

public class Login {


    private Input input = new Input();
    private User user;

    public void loginToDb(){

        UserDAO userDao = new UserDAO();
        user =  userDao.selectUser();
        if (user == null){
            System.out.println("You have to register first\n");
            input.getEmptyInput();
            userDao.insertInto();

        }
        else {
            System.out.println("\nYou might do shopping");
        }
    }
}
