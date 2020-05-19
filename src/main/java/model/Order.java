package model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime paidAt;
    private OrderStatus orderStatus;
    private Cart cart;

    public Order(int id, User user, Cart cart){
        this.id = id;
        this.user = user;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Cart getCart() {
        return cart;
    }

}
