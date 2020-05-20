package com.codecool.coffeeteashop.model;

public class Customer extends User {

    private final String phoneNumber;


    public Customer(int id, String email, String password, String name, String surname, String phoneNumber) {
        super(id, email, password, name, surname);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

