package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTestSuite {

    @Autowired
    OrderService orderService;

    @Test
    public void shouldCreateAndDeleteOrder() {
        //Given
        Cart cart = new Cart("testCart", "Cart added for test", 550.00);
        User user = new User("UserNo1", true, 10l);
        Order order = new Order(user.getId(),cart.getId());

        //When
        orderService.saveOrder(order);
//        Order savedOrder = orderService.saveOrder(order);

        //Then
//        Assert.assertNotNull(savedOrder);
//        Assert.assertNotNull(order.getId());

        //CleanUp
//        orderService.delete(order);
    }
}
