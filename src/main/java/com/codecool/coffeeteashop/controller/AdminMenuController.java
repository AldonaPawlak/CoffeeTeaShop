package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.ProductCategoryDAO;

public class AdminMenuController {
    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();


    public void addNewProductCategory () {
        System.out.println("ADDING THE NEW PRODUCT CATEGORY");
        productCategoryDAO.insertInto();
    }

    public void editProductCategoryName() {
        System.out.println("EDITING NAME OF PRODUCT CATEGORY");
        productCategoryDAO.update();
    }
}
