package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORDERS")
public class Order {
    private Long id;
    private String userId;
    private String cartId;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @JoinColumn(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    @JoinColumn(name = "CART_ID")
    public String getCartId() {
        return cartId;
    }

    public Order() {
    }

    public Order(Long id, String userId, String cartId) {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}