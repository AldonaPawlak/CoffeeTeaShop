
package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.OrderDAO;
import com.codecool.coffeeteashop.controller.DAO.ProductCategoryDAO;
import com.codecool.coffeeteashop.controller.DAO.ProductDAO;
import com.codecool.coffeeteashop.model.Cart;
import com.codecool.coffeeteashop.model.Product;
import com.codecool.coffeeteashop.model.User;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMenuController {
    Cart cart;
    UI ui = new UI();
    User user;
    Input input = new Input();
    ProductDAO productDAO = new ProductDAO();

    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();

    public CustomerMenuController(User user) {
        this.user = user;
    }

    public void userOptions() throws IOException {

        boolean isRunning  = true;
        while (isRunning) {
            ui.printUserMenu();
            int userChoice = input.getIntegerInput("What do you want to do right now?\n");
            if(userChoice == 0) {
                isRunning = false;
            }
            switch (userChoice) {
                case 1: {
                    productDAO.select();
                    input.getEmptyInput();
                    //checkAvailibilityOfProduct(); call in other place
//                productDAO.updateRating("Arabica", 4);
                    break;
                }
                case 2: {
                    showSpecificCategory();
                    break;
                }
                case 3: {
                    cart = shopping();
                    System.out.println(cart.toString());
                    break;
                }
                case 4: {

                    break;
                }
                case 5: {

                    break;
                }
                case 6: {

                    break;
                }
                case 7 : {
                    getProductsWithRates();
                    break;
                }
            }
        }
    }

    private Cart shopping() throws IOException {
        List<Product> products = new ArrayList<>();
        boolean keepBuying = true;
        while(keepBuying) {
            productDAO.select();
            int productId = input.getIntegerInput("Enter product Id you want to buy or 0 to back to menu: ");
            if (productId == 0) {
                keepBuying = false;
            }
            Product chosenProduct = productDAO.getProduct(productId);
            products.add(chosenProduct);
        }
        Cart cart = new Cart(products, user);

        return cart;
    }

    private void showSpecificCategory() throws IOException {
        productCategoryDAO.select();
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