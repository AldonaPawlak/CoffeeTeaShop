package com.codecool.coffeeteashop.model;

import com.codecool.coffeeteashop.controller.DAO.ProductDAO;

import java.util.ArrayList;
import java.util.Map;

public class Cart {
    private Integer id;
    private ArrayList<Product> products;
    Product product;
    ProductDAO productDAO = new ProductDAO();

    public Cart(int id, ArrayList<Product> products) {
        this.id = id;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Product> products() {
        return products;
    }

    public void addToCart() {
         // TODO
    }

    public void editCart() {
        // TODO
    }

    public void emptyCart() {
        // TODO
    }

    public void removeFromCart() {
        // TODO
    }

    public void getProducts() {
        // TODO
    }

    public void countTotalPrice() {
        // TODO
    }

}
