package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private Long cartId;
}
