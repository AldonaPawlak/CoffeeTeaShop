package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

public class CustomerMenuController {
    UI ui = new UI();
    Input input = new Input();

    public CustomerMenuController() {
    }

    public void userOptions() {
        ui.printUserMenu();
        final int userChoice = input.getIntegerInput("What do you want to do right now?");
    }
}
