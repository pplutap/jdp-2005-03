package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(final Long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }

    public Optional<Order> getOrderIdByCartId(final Long cartId){
        Long orderId = orderRepository.getOrderIdByCartId(cartId);
        return orderRepository.findById(orderId);
    }

    public List<Long> getOrdersByUserId(final Long id){
        List<Long> orderList = orderRepository.getOrderIdByUserId(id);
        return orderList;
    }
}