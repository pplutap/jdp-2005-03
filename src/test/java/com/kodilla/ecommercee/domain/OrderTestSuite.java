package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.service.OrderService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderTestSuite {

    @Autowired
    OrderService orderService;

    @Test
    public void shouldSaveOrder() {
        //Given
        Order order = new Order(1L,1L);

        //When
        Order savedOrder = orderService.saveOrder(order);
        Long orderId = savedOrder.getId();

        //Then
        Assert.assertNotNull(savedOrder);
        Assert.assertNotNull(order.getId());

        //CleanUp
        orderService.deleteOrder(orderId);
    }

    @Test
    public void shouldReadeSavedOrder() {
        //Given
        Order order1 = new Order(2L,2L);

        //When
        Order savedOrder1 = orderService.saveOrder(order1);

        //Then
        Long orderId = savedOrder1.getId();
        Long userId = savedOrder1.getUserId();
        Long cartId = savedOrder1.getCartId();

        Assert.assertEquals((Long)1L,orderId);
        Assert.assertEquals((Long)2L,userId);
        Assert.assertEquals((Long)2L,cartId);

        //CleanUp
        orderService.deleteOrder(orderId);
    }

    @Test
    public void shouldUpdateSavedOrder() {
        //Given
        Order order2 = new Order(3L,3L);

        //When
        Order savedOrder = orderService.saveOrder(order2);

        //Then
        Long orderId = savedOrder.getId();
        Long userId = savedOrder.getUserId();
        Long cartId = savedOrder.getCartId();

        Assert.assertEquals((Long)1L,orderId);
        Assert.assertEquals((Long)3L,userId);
        Assert.assertEquals((Long)3L,cartId);

        savedOrder.setCartId(4L);
        savedOrder.setUserId(4L);

        orderService.saveOrder(savedOrder);

        Long modifiedUserId = savedOrder.getUserId();
        Long modifiedCartId = savedOrder.getCartId();

        Assert.assertEquals((Long)1L,orderId);
        Assert.assertEquals((Long)4L,modifiedUserId);
        Assert.assertEquals((Long)4L,modifiedCartId);

        //CleanUp
        orderService.deleteOrder(orderId);
    }

    @Test
    public void shouldDeleteOrder() {
        //Given
        Order order3 = new Order(5L,5L);

        //When
        Order savedOrder = orderService.saveOrder(order3);
        Long orderId = savedOrder.getId();

        //Then
        int orderListSize = orderService.getAllOrders().size();
        Assert.assertEquals(1,orderListSize);

        orderService.deleteOrder(orderId);

        int deletedOrderId = orderService.getAllOrders().size();
        Assert.assertEquals(0,deletedOrderId);

        //CleanUp
    }

    @Test
    public void shouldFindOrderByCartId() {
        //Given
        Order order4 = new Order(6L,6L);
        Order order5 = new Order(7L,7L);

        //When
        orderService.saveOrder(order4);
        orderService.saveOrder(order5);

        //Then
        Long orderId = orderService.getOrderIdByCartId(7L).get().getId();

        Assert.assertEquals((Long)2L, orderId);

        //CleanUp
        orderService.delete(order4);
        orderService.delete(order5);
    }
}
