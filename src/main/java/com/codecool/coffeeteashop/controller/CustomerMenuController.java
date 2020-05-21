
package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.ProductDAO;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

import java.io.IOException;

public class CustomerMenuController {
    UI ui = new UI();
    Input input = new Input();
    ProductDAO productDAO = new ProductDAO();

    public CustomerMenuController() {
    }

    public void userOptions() throws IOException {
        ui.printUserMenu();
        final int userChoice = input.getIntegerInput("What do you want to do right now?\n");
        switch (userChoice) {
            case 1 : {
                //checkAvailibilityOfProduct(); call in other place
                productDAO.updateRating("Coffee", 4);
                break;
            }
            case 2 : {
                showSpecificCategory();
                break;
            }
            case 3 : {

                break;
            }
            case 4 : {

                break;
            }
            case 5 : {

                break;
            }
            case 6 : {
                getProductsWithRates();
                break;
            }
        }
    }

    private void showSpecificCategory() throws IOException {
        String category = input.getStringInput("Which category you want to show?\n").toLowerCase();
        int categoryId = getCategoryId(category);
        ProductDAO productDAO = new ProductDAO();
        productDAO.selectSpecificCategory(categoryId);
    }

    private int getCategoryId(String categoryName){
        if (categoryName.equals("coffee")){
            return 1;
        }
        else if (categoryName.equals("tea")){
            return 2;
        }
        else if (categoryName.equals("sugar")){
            return 3;
        }
        else if (categoryName.equals("coffee cups")){
            return 4;
        }
        else if (categoryName.equals("chocolate")){
            return 5;
        }

        return 1;
    }

    private void checkAvailibilityOfProduct() throws IOException {
        String product = input.getStringInput("Which product you want to availibility to check?\n");
        int productId = getProductID(product);
        ProductDAO productDAO = new ProductDAO();
        productDAO.selectSpecificProductAvailability(productId);
    }

    private int getProductID(String productName) {
        if (productName.equalsIgnoreCase("Arabica")) {
            return 1;
        }
        else if (productName.equalsIgnoreCase("Robusta")) {
            return 2;
        }
        else if (productName.equalsIgnoreCase("Liberika")) {
            return 3;
        }
        return 0;
    }

    private void getProductsWithRates() {
        productDAO.selectAllProductsWithRates();
    }
}