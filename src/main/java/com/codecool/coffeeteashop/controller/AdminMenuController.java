
package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.OrderDAO;
import com.codecool.coffeeteashop.controller.DAO.ProductCategoryDAO;
import com.codecool.coffeeteashop.controller.DAO.ProductDAO;
import com.codecool.coffeeteashop.model.User;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

import java.io.IOException;

public class AdminMenuController {
    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();
    ProductDAO productDAO = new ProductDAO();
    UI ui = new UI();
    Input input = new Input();
    User user;
    OrderDAO orderDAO = new OrderDAO(user);

    public void adminOptions() throws IOException { // should be used in case someone will register as admin
        ui.printAdminMenu();
        final int adminChoice = input.getIntegerInput("What do you want to do right now?");
        switch (adminChoice) {
            case 1: {
                addNewProductCategory ();
                break;
            }
            case 2: {
                editProductCategoryName();
                break;
            }
            case 3: {
                productDAO.deactivateProductAutomatically();
                break;
            }
            case 4: {
                addNewProduct();
                break;
            }
            case 5: {
                productDAO.editProduct();
                break;
            }
            case 6: {
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                chheckingorderStatuses();
                break;
            }
            case 9: {
                deactivateProduct();
            }
        }
    }

    public void editProductName() throws IOException{
        ui.print("EDITING NAME OF PRODUCT CATEGORY");
        productCategoryDAO.update();
    }

    public void addingNewProductCategoryToDB() throws IOException{
        ui.print("ADDING THE NEW PRODUCT CATEGORY");
        productCategoryDAO.insertInto();
    }


       public void addNewProductCategory () throws IOException {
             System.out.println("ADDING THE NEW PRODUCT CATEGORY");
       	        productCategoryDAO.insertInto();

    }

    public void editProductCategoryName() throws IOException {
                System.out.println("EDITING NAME OF PRODUCT CATEGORY");
        	        productCategoryDAO.update();

    }

    public void addNewProduct() throws IOException {
        System.out.println("ADDING THE NEW PRODUCT");
        productDAO.insertInto();
    }


    private void deactivateProduct() {
        ui.print("DEACTIVATING PRODUCT");
        productDAO.update();
    }

    private void chheckingorderStatuses() {
        orderDAO.ordersWithStatuses();
    }

    private void statisticsFeedbackFromUsers() {
        productDAO.feedbackStatistics();
    }

}

