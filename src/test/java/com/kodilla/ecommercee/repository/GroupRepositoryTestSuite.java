package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GroupRepositoryTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testGroupRepositorySave() {
        //Given
        Group group1 = new Group("Ubrania");
        //When
        groupRepository.save(group1);
        //Then
        Long groupId = group1.getId();
        Optional<Group> productsGroups = groupRepository.findById(groupId);
        Assert.assertTrue(productsGroups.isPresent());
        //CleanUp
        groupRepository.delete(group1);
    }

    @Test
    public void testGroupRepositoryFindById() {
        //Given
        Group group4 = new Group("Obuwie" );
        groupRepository.save(group4);
        Long groupId = group4.getId();
        //When
        Optional<Group> productsGroups = groupRepository.findById(groupId);
        //Then
        Assert.assertEquals(groupId, productsGroups.get().getId());
        //CleanUp
        groupRepository.delete(group4);

    }

    @Test
    public void testGroupRepositorySaveWithProduct(){
        //Given
        Group group1 = new Group ("Ubrania");
        Product product = new Product("Kurtka zimowa", "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus", (100), 1L);
        List<Product> productList = new ArrayList<Product>();
        productList.add(product);
        group1.setProductList(productList);
        //When
        groupRepository.save(group1);
        Long groupId = group1.getId();
        Optional<Group> productsGroups= groupRepository.findById(groupId);
        //Then
        Assert.assertEquals(groupId, productsGroups.get().getId());
        Assert.assertEquals("Ubrania", group1.getName());
        //CleanUp
        groupRepository.deleteById(groupId);

    }
}



