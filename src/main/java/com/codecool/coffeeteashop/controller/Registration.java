package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.UserDAO;

public class Registration {


    private UserDAO userDao;

    public Registration(UserDAO userDao) {
        this.userDao = userDao;
    }

    public void register(){
        userDao.insertInto();
    }

    public UserDAO getUserDao() {
        return userDao;
    }

}
