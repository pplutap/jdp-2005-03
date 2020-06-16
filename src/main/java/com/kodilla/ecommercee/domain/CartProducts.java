package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CART_PRODUCTS")

public class CartProducts {

    @Id
    @GeneratedValue()
    private Long id;

    private Long cartId;

    private Long productId;

    public CartProducts() {
    }

}
