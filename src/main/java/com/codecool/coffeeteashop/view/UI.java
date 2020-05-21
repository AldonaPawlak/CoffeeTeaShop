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

                + "1 - log in\n"
                + "2 - registration\n"
                + "0 - EXIT\n");

    }

    public void printUserMenu() {
        System.out.println("Menu:\n"

                + "1 - Show all products:\n"
                + "2 - Choose category of products to show\n"
                + "3 - Show quantity of my basket\n"
                + "4 - Show my previous orders\n"
                + "5 - Show statistics of my orders\n"
                + "6 - Show all products with rates\n"
                + "0 - Back to previous menu\n");
    }

    public void printProductMenu() {
        System.out.println("Product menu:\n"
                + "1 - add product\n"
                + "2 - rate product (1-5)\n"
                + "3 - show availability\n");
    }

    public void printUserBasketMenu() {
        System.out.println("Basket menu:\n"
                + "1 - Change product quantity\n"
                + "2 - Delete product from cart\n"
                + "3 - Place order\n");
    }

    public void printBasketContent() {
        System.out.println("Choose 1 to print basket content");
    }

    public void printAdminMenu() {
        System.out.println("Admin menu:\n"

                + "1 - create new product category\n"
                + "2 - change product category name\n"
                + "3 - deactivate product automaticly when 0\n"
                + "4 - add new product\n"
                + "5 - edit product\n"
                + "6 - give a limited discount on some products\n"
                + "7 - see the list of ongoing orders\n"
                + "8 - see statistics of orders\n"
                + "9 - deactivate product\n"
                + "10 - see feedbac statistics\n");
    }
}

