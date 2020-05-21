package com.codecool.coffeeteashop.model;

import com.codecool.coffeeteashop.controller.DAO.OrderDAO;
import com.codecool.coffeeteashop.controller.DAO.ProductDAO;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart {
    private UI ui = new UI();
    private Input input = new Input();
    private User user;
    private Integer id;
    private List<Product> products = new ArrayList<Product>();
    Product product;
    ProductDAO productDAO = new ProductDAO();

    public Cart(int id, ArrayList<Product> products, User user) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addToCart() {
        products.add(product);
    }

    public void editCart() throws IOException {
        ui.printUserBasketMenu();
        int option = input.getIntegerInput("Enter option: ");
        switch (option){
            case 1:
                ui.print("CHANGE PRODUCT QUANTITY");
                changeQuantityOfProduct();
                editCart();
                break;
            case 2:
                ui.print("DELETE PRODUCT FROM CART");
                removeFromCart();
                editCart();
                break;
            case 3:
                ui.print("Your order have been placed");
                OrderDAO orderDAO = new OrderDAO(user);
                orderDAO.insertInto();
                break;
            default:
                ui.print("Wrong option!");
                editCart();
        }
    }

    public void emptyCart() {
            products.clear();
    }

    public void changeQuantityOfProduct() throws IOException {
        String productName = input.getStringInput("Enter name of the product to edit: ");
        int quantity = input.getIntegerInput("Enter quantity of product: ");
        for (Product product : products){
            if (product.getName().equals(productName)){
                product.setQuantity(quantity);
            }
        }
    }

    public void removeFromCart() throws IOException {
        String productNameToDelete = input.getStringInput("Enter name of the product to delete: ");
        products.removeIf(productToDelete -> product.getName().equals(productNameToDelete));
    }


    public int countTotalPrice() {
        int totalPrice = 0;
        for (Product product : products){
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

}
