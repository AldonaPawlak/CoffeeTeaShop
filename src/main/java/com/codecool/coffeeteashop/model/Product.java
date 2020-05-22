package com.codecool.coffeeteashop.model;

import com.codecool.coffeeteashop.controller.DAO.ProductDAO;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

import java.io.IOException;

public class Product {

    private final int id;
    private final String name;
    private final String description;
    private final double price;
    private int quantity;
    private final int idCategory;
    private final int rating;
    private final int numberOfRates;
    private final boolean isAvailable;
    private UI ui = new UI();
    private Input input = new Input();


    public Product(int id, String name, String description, double price, int quantity, int idCategory, int rating, int numberOfRates, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.idCategory = idCategory;
        this.rating = rating;
        this.numberOfRates = numberOfRates;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public int getRating() {
        return rating;
    }

    public int getNumberOfRates() {
        return numberOfRates;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void productMenu() throws IOException {
        ui.printProductMenu();
        int option = input.getIntegerInput("Enter option: ");
        switch (option){
            case 1:
                ui.print("Add product");
                productMenu();
                break;
            case 2:
                ui.print("Rate product");
                int userRating = input.getIntegerInput("Enter rates 1-5");
                ProductDAO productDAO = new ProductDAO();
                productDAO.updateRating(this.name, userRating);
                productMenu();
                break;
            case 3:
                ui.print("show availability");
                productMenu();
                break;
            case 0:
                break;
            default:
                ui.print("Wrong option");
                productMenu();
                break;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", idCategory=" + idCategory +
                ", rating=" + rating +
                ", numberOfRates=" + numberOfRates +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
