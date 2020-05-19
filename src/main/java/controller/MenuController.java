package controller;

import controller.DAO.UserDAO;
import model.User;
import view.UI;

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
        // TODO
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
