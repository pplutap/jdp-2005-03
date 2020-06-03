package com.kodilla.ecommercee.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Long userId;
    private Long cartId;
}
