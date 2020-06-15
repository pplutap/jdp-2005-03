package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CART")
public class Cart {

    private int id;
    private String name;
    private String description;
    private double price;
    private CartProducts cartProducts;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    @Embedded
    @Column(name="CART_PRODUCTS_ID")
    public CartProducts getCartProducts() {
        return cartProducts;
    }

    public Cart() {
    }

    public Cart(int id, String name, String description, double price, CartProducts cartProducts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.cartProducts=cartProducts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCartProducts(CartProducts cartProducts) {
        this.cartProducts = cartProducts;
    }
}
