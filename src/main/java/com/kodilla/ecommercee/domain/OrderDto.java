package com.kodilla.ecommercee.domain;

public class OrderDto {
    private Long id;
    private Long userId;
    private Long cartId;

    public OrderDto(Long id, Long userId, Long cartId) {
        this.id = id;
        this.userId = userId;
        this.cartId = cartId;
    }

    public OrderDto(Long userId, Long cartId) {
        this.id = id;
        this.userId = userId;
        this.cartId = cartId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCartId() {
        return cartId;
    }
}
