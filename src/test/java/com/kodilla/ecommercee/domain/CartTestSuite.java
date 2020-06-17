package com.kodilla.ecommercee.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartTestSuite {

    @Test
    public void shouldCreateCart(){
        //Given
        Cart cart = new Cart("testCart","Cart added for test", 550.00);

        //When
        String cartName = cart.getName();
        String cartDescriptiom = cart.getDescription();
        double totalCartPrice = cart.getPrice();

        //Then
        Assert.assertEquals("testCart", cartName);
        Assert.assertEquals("Cart added for test", cartDescriptiom);
        Assert.assertEquals(550.00, totalCartPrice,0);
    }



}
