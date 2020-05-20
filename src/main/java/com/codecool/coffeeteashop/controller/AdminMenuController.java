package com.codecool.coffeeteashop.controller;

import com.codecool.coffeeteashop.controller.DAO.ProductCategoryDAO;

public class AdminMenuController {
    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();


    public void addNewProductCategory () {
        System.out.println("ADDING THE NEW PRODUCT CATEGORY");
        productCategoryDAO.insertInto();


    }
}
