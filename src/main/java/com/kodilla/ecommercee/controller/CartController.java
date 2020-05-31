package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ecommercee/cart")
public class CartController {
    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public CartDto getCart() {
        return new CartDto(1L, "first test", "description of the first test", 8.0, "1");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public void deleteCart(Long id) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(CartDto cartDto) {

    }
}
