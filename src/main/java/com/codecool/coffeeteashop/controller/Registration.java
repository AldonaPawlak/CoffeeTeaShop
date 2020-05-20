package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.UserDAO;
import com.codecool.coffeeteashop.model.User;
import com.codecool.coffeeteashop.view.Input;

public class Registration {
    private User user;

    public void register(){
        UserDAO userDAO = new UserDAO();
        userDAO.insertInto();
    }
}
