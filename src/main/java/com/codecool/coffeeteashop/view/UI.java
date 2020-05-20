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
        System.out.println("menu\n"
                         + "1 - log in\n"
                         + "2 - registartion\n"
                         + "0 - EXIT\n");
    }
}
