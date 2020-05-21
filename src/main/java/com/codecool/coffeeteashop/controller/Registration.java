package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.Program;
import com.codecool.coffeeteashop.controller.DAO.UserDAO;
import com.codecool.coffeeteashop.view.UI;

import java.io.IOException;

public class Registration {


    private UserDAO userDao;

    public Registration(UserDAO userDao) {
        this.userDao = userDao;
    }

    public void register(Program program, UI ui) throws IOException {
        userDao.insertInto();
        ui.print("\nRegistration complete\n");

        program.runProgram();
    }

    public UserDAO getUserDao() {
        return userDao;
    }


}
