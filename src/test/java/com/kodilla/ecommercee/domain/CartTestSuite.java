package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.service.CartService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartTestSuite {

    @Autowired
    CartService cartService;

    @Test
    public void shouldCreateAndDeleteCart() {
        //Given
        Cart cart = new Cart("testCart", "Cart added for test", 550.00);

        //When
        Cart savedCart = cartService.save(cart);

        //Then
        Assert.assertNotNull(savedCart);
        Assert.assertNotNull(cart.getId());

        //CleanUp
        cartService.delete(cart);
    }

    @Test
    public void shouldCreateAndDeleteCarts() {
        //Given
        List<Cart> cartList = new ArrayList<>();
        Cart cart1 = new Cart("testCart#1", "Cart#1 added for test", 550.00);
        Cart cart2 = new Cart("testCart#2", "Cart#2 added for test", 921.15);
        cartList.add(cart1);
        cartList.add(cart2);

        //When
        cartService.saveAll(cartList);
        //Then
        Assert.assertNotNull(cartService.findById(cart1.getId()));
        Assert.assertNotNull(cartService.findById(cart2.getId()));

        //CleanUp
        cartService.delete(cart1);
        cartService.delete(cart2);
    }

    @Test
    public void shouldFindAndSaveModifiedCart() {
        //Given
        Cart cart = new Cart("testCart", "Cart added for test", 550.00);

        //When
        cartService.save(cart);
        String originalCartName = cart.getName();
        cart.setName("Modified test Cart");
        cartService.save(cart);
        Cart modifiedCart = cartService.findById(cart.getId());

        //Then
        Assert.assertNotEquals(originalCartName, modifiedCart.getName());
        Assert.assertEquals("Modified test Cart", modifiedCart.getName());

        //CleanUp
        cartService.delete(cart);
    }

}