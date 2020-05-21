package com.codecool.coffeeteashop.model;

import com.codecool.coffeeteashop.controller.DAO.OrderDAO;
import com.codecool.coffeeteashop.controller.DAO.ProductDAO;
import com.codecool.coffeeteashop.view.Input;
import com.codecool.coffeeteashop.view.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cart {
    private UI ui = new UI();
    private Input input = new Input();
    private User user;
    private Integer id;
//    private Map<Product, Integer> products;
    private List<Product> products;
    Product product;
    ProductDAO productDAO = new ProductDAO();

    public Cart(List<Product> products, User user) {
        this.user = user;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addToCart(Product product){
        products.add(product);
    }

//    public void addToCart() {
//        products.merge(product, 1, Integer::sum);
//    }

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

//        Set<Map.Entry<Product, Integer>> entries = products.entrySet();
//        for (Map.Entry<Product, Integer> entry : entries) {
//            if(entry.getKey().getName().equals(productName)){
//                entry.getKey().setQuantity(quantity);
//            }
//        }

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

    @Override
    public String toString() {
        return "Cart{" +
                "user=" + user +
                ", products=" + products +
                '}';
    }
}
