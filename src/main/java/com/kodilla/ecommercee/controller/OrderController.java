package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommercee/order")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = "getOrderList")
    public List<OrderDto> getOrderList(){
        return orderMapper.mapToOrderDtoList(orderService.getAllOrders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(orderService.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderMapper.mapToOrder(orderDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto){
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) throws OrderNotFoundException{
        if(orderService.getOrder(orderId).isPresent())
            orderService.deleteOrder(orderId);
        else
            throw new OrderNotFoundException();
    }
}