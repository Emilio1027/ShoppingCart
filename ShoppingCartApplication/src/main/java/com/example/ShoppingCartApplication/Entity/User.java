package com.example.ShoppingCartApplication.Entity;


import javax.persistence.*;

@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int userID;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    public User() {
    }

    public User(Cart cart) {
        this.cart = cart;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
