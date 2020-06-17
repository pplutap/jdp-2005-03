package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartAndProductDto;
import com.kodilla.ecommercee.domain.CartProducts;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.CartAndProductRepository;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartServiceTestSuite {

    @Autowired
    CartService cartService;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartAndProductRepository cartAndProductRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldGetCartAndProduct() {
        //Given
        Cart cart = new Cart(1L, "testCart", "Cart created for test", 500.00);
        cartRepository.save(cart);
        CartProducts cartProducts01 = new CartProducts(1L, 1L, 1L);
        CartProducts cartProducts02 = new CartProducts(2L, 1L, 2L);
        cartAndProductRepository.save(cartProducts01);
        cartAndProductRepository.save(cartProducts02);
        Product product01 = new Product(1L, "testProduct01", "Product for test#01", 250.00, 1L);
        Product product02 = new Product(2L, "testProduct02", "Product for test#02", 270.00, 4L);
        productRepository.save(product01);
        productRepository.save(product02);
        //When
        CartAndProductDto cartAndProductDto = cartService.getCartAndProduct(1L);
        //Then

    }
}
