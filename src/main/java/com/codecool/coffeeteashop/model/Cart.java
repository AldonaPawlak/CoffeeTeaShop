package com.codecool.coffeeteashop.model;

import com.codecool.coffeeteashop.controller.DAO.ProductDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart {
    private Integer id;
    private List<Product> products = new ArrayList<Product>();
    Product product;
    ProductDAO productDAO = new ProductDAO();

    public Cart(int id, ArrayList<Product> products) {
        this.id = id;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public List<Product> products() {
        return products;
    }

    public void addToCart() {
        products.add(product);
    }

    public void editCart() {
        // TODO
    }

    public void emptyCart() {
            products.clear();
    }

    public void removeFromCart() {
        products.remove(product);
    }

    public void getProducts() {
        // TODO
    }

    public void countTotalPrice() {
        // TODO
    }

}
