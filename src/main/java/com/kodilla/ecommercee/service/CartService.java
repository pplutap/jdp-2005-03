package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartAndProductDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.repository.CartAndProductRepository;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartAndProductRepository cartAndProductRepository;

    public CartAndProductDto getCartAndProduct(Long id){
        Cart testCart = cartRepository.findById(id).orElseThrow(()-> new IllegalArgumentException());
        List<Long> productIds = cartAndProductRepository.getProductIds(testCart.getId());
        List<Product> products = new ArrayList<>();
        for(Long productId : productIds){
            products.add(productRepository.findById(productId).orElseThrow(()->new IllegalArgumentException()));
        }
        List<ProductDto> productDtos = products.stream()
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getGroupId()))
                .collect(Collectors.toList());
        return new CartAndProductDto(testCart.getId(),testCart.getName(),testCart.getDescription(),testCart.getPrice(),productDtos);
    }

    public Cart save (Cart cart){
        return cartRepository.save(cart);
    }

    public void saveAll(List<Cart> carts){
        cartRepository.saveAll(carts);
    }

    public Cart findById(Long id){
        return cartRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
    }

    public void delete (Cart cart){
        cartRepository.delete(cart);
    }

}
