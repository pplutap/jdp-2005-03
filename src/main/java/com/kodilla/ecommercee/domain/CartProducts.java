package com.kodilla.ecommercee.domain;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class CartProducts {
    private List<Long> productsId;

    public CartProducts() {
    }

}
