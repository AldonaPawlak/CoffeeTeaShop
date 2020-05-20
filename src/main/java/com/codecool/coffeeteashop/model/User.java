package com.codecool.coffeeteashop.model;

public class User {

    private final int id;
    private final String name;
    private final String surname;
    private final String mail;
    private final String password;
    private final int phone;
    private final String rights;

    public User(int id, String name, String surname, String mail, String password, int phone, String rights) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.rights = rights;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public String getRights() {
        return rights;
    }
}
