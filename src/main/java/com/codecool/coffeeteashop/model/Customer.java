package com.codecool.coffeeteashop.model;

import com.codecool.coffeeteashop.controller.CustomerMenuController;

import java.io.IOException;

public class Customer extends User {


    public Customer(int id, String name, String surname, String mail, String password, int phone, String rights) {
        super(id, name, surname, mail, password, phone, rights);
    }

    @Override
    public void displayMenuOptions() throws IOException {
        System.out.println("\nYou might do shopping\n");
        CustomerMenuController customerMenuController = new CustomerMenuController(this);

        customerMenuController.userOptions();
    }
}

