package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class CartAndProductDto extends CartDto{

    private List<ProductDto> productDtos = new ArrayList<>();

    public CartAndProductDto(Long id, String name, String description, Double price, List<ProductDto> productDtos) {
        super(id, name, description, price);
        this.productDtos = productDtos;
    }
}
