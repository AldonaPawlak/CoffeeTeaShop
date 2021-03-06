package com.codecool.coffeeteashop.model;

import com.codecool.coffeeteashop.controller.AdminMenuController;

import java.io.IOException;

public class Admin extends User {


    public Admin(int id, String name, String surname, String mail, String password, int phone, String rights) {
        super(id, name, surname, mail, password, phone, rights);
    }

    @Override
    public void displayMenuOptions() throws IOException {
        AdminMenuController adminMenuController = new AdminMenuController();
        adminMenuController.adminOptions();
    }
}
