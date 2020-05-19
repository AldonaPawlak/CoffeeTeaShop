package model;

import java.util.Map;

public class Cart {
    private Integer id;
    private Map<Product, Integer> products;
    Product product;

    public Cart(int id, Map<Product, Integer> products) {
        this.id = id;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public Map<Product, Integer> products() {
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
