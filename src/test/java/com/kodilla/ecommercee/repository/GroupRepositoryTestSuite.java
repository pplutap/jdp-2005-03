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

    @Test
    public void testGroupRepositorySave() {
        //Give
        Group group1 = new Group("Ubrania");
        //When
        groupRepository.save(group1);
        //Then
        Long groupId = group1.getId();
        Optional<Group> productsGroups = groupRepository.findById(groupId);
        Assert.assertTrue(productsGroups.isPresent());
        //CleanUp
        groupRepository.deleteById(groupId);
    }

    @Test
    public void testGroupRepositoryFindAll() {
        //Given
        Group group1 = new Group("Ubrania");
        Group group2 = new Group("Dodatki");
        Group group3 = new Group("Biżuteria");
        Group group4 = new Group("Obuwie");
        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
        groupRepository.save(group4);
        //When
        List<Group> productsGroups = groupRepository.findAll();
        //Then
        Assert.assertEquals(4, productsGroups.size());
        //CleanUp
        groupRepository.deleteAll();
        groupRepository.delete(group1);
        groupRepository.delete(group2);
        groupRepository.delete(group3);
        groupRepository.delete(group4);
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
        groupRepository.deleteById(groupId);
     }

    @Test
    public void testGroupRepositorySaveWithProduct(){
        //Given
        Group group1 = new Group ("Ubrania");
        Product product = new Product("Kurtka zimowa", "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus", (100), "1");
        List<Product> productList = new ArrayList<Product>();
        productList.add(product);
        group1.setProductList(productList);
        //When
        groupRepository.save(group1);
        Long groupId = group1.getId();
        int productListSize = group1.getProductList().size();
        Optional<Group> productsGroups= groupRepository.findById(groupId);
        //Then
        Assert.assertEquals(groupId, productsGroups.get().getId());
        Assert.assertEquals(1,productListSize);
        Assert.assertEquals("Ubrania", group1.getName());
        //CleanUp
        groupRepository.deleteById(groupId);

    }
}
