package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.controller.GroupNotFoundException;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTestSuite {

    @Autowired
    private ProductService productService;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test(expected = GroupNotFoundException.class)
    public void shouldThrowExceptionWhileSavingProductWithNotExistingGroup() {
        //Given
        Product product = new Product("test", "test desc", 11.2, 1L);
        //When
        productService.save(product);
    }

    @Test
    public void shouldSaveProduct() {
        //Given
        Group group = new Group(1L, "testGroup");
        groupRepository.save(group);
        Product product = new Product("test", "test desc", 11.2, 1L);
        //When
        Product saved = productService.save(product);
        //Then
        Assert.assertNotNull(saved);
        //CleanUp
        //groupRepository.delete(group);
       // productRepository.delete(product);
    }
}