package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.UserDAO;
import com.codecool.coffeeteashop.model.User;
import com.codecool.coffeeteashop.view.UI;

public class MenuController {

    private UserDAO userDao;
    private User user;
    private UI ui;

    public MenuController(UserDAO userDao, User user, UI ui) {
        this.userDao = userDao;
        this.user = user;
        this.ui = ui;
    }

    public void createUserProfileMenu() {
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public User getUser() {
        return user;
    }

    public UI getUi() {
        return ui;
    }
}
