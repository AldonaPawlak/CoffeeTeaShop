package com.codecool.coffeeteashop.model;

public class Product {

    private final int id;
    private final String name;
    private final float price;
    private int quantity;
    private final int categoryId;
    private final Boolean isAvailable;


    public Product(int id, String name, float price, int quantity, int categoryId, Boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }
}
