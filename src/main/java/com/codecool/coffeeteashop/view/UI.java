package com.codecool.coffeeteashop.view;

import java.text.DecimalFormat;

public class UI {
    private DecimalFormat df = new DecimalFormat("0.00");

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void print(String string){
        System.out.println(string);
    }

    public void print(Integer integer){
        System.out.println(integer);
    }

    public void print(Float floatNumber){
        System.out.println(df.format(floatNumber));
    }

    public void printTableOf(Object object){
        TableProvider tableProvider = new TableProvider();
    }

    public void printMenu() {
        System.out.println("menu:\n"
<<<<<<< HEAD
                + "1 - log in\n"
                + "2 - registration\n"
                + "0 - EXIT\n");
=======
                         + "1 - log in\n"
                         + "2 - registration\n"
                         + "0 - EXIT\n");
>>>>>>> 7e7634dd7d708bdb0e9a5b9e4a1412e6977c25c7
    }

    public void printUserMenu() {
        System.out.println("Menu:\n"
<<<<<<< HEAD
                + "1 - Show all products:\n"
                + "2 - Choose category of products to show"
                + "3 - Show quantity of my basket\n"
                + "4 - Show my previous orders\n"
                + "5 - Show statistics of my orders\n");
=======
                          + "1 - Show all products:\n"
                          + "2 - Choose category of products to show"
                          + "3 - Show quantity of my basket\n"
                          + "4 - Show my previous orders\n"
                          + "5 - Show statistics of my orders\n");
>>>>>>> 7e7634dd7d708bdb0e9a5b9e4a1412e6977c25c7
    }

    public void printProductMenu() {
        System.out.println("Product menu:\n"
<<<<<<< HEAD
                + "1 - add product\n"
                + "2 - rate product (1-5)\n"
                + "3 - show availability\n");
=======
                         + "1 - add product\n"
                         + "2 - rate product (1-5)\n"
                         + "3 - show availability\n");
>>>>>>> 7e7634dd7d708bdb0e9a5b9e4a1412e6977c25c7
    }

    public void printUserBasketMenu() {
        System.out.println("Basket menu:\n"
                + "1 - Change product quantity\n"
                + "2 - Delete product from cart\n"
                + "3 - Place order\n");
    }

    public void printBasketContent() {
        //TODO
    }

    public void printAdminMenu() {
        System.out.println("Admin menu:\n"
<<<<<<< HEAD
                + "1 - create new product category\n"
                + "2 - change product category name\n"
                + "3 - deactivate product\n" //it shoud be automaticly if quantity = 0 also
                + "4 - add new product\n"
                + "5 - edit product\n"
                + "6 - give a limited discount on some products\n"
                + "7 - see the list of ongoing orders\n"
                + "8 - see statistics of orders\n");
    }


}
=======
                          + "1 - create new product category\n"
                          + "2 - change product category name\n"
                          + "3 - deactivate product\n" //it shoud be automaticly if quantity = 0 also
                          + "4 - add new product\n"
                          + "5 - edit product\n"
                          + "6 - give a limited discount on some products\n"
                          + "7 - see the list of ongoing orders\n"
                          + "8 - see statistics of orders\n");
    }


}
>>>>>>> 7e7634dd7d708bdb0e9a5b9e4a1412e6977c25c7
