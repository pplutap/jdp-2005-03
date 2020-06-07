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

     //@Test
    // public void testGroupRepositorySave() {
    // //Given
       // Group group1 = new Group("Ubrania");
       // //When
       // groupRepository.save(group1);
       // //Then
       //Long id = group1.getId();
       //Optional<Group> productsGroups = groupRepository.findById(id);
       // Assert.assertTrue(productsGroups.isPresent());
       // //CleanUp
       // groupRepository.deleteById(id);
    //}

    //@Test
    //public void testGroupRepositoryFindAll() {

    //    //Given
    //    Group group1 = new Group("Ubrania");
    //    Group group2 = new Group("Dodatki");
    //    Group group3 = new Group("Biżuteria");
    //    Group group4 = new Group("Obuwie");
    //    groupRepository.save(group1);
    //   groupRepository.save(group2);
    //    groupRepository.save(group3);
    //    groupRepository.save(group4);
    //    //When
    //    List<Group> productsGroups = groupRepository.findAll();
    //    //Then
    //    Assert.assertEquals(4, productsGroups.size());
    //    //CleanUp
    //    //groupRepository.deleteAll();
    //    groupRepository.delete(group1);
    //    groupRepository.delete(group2);
    //    groupRepository.delete(group3);
    //    groupRepository.delete(group4);
    //}

   // @Test
   // public void testGroupRepositoryFindById() {
   //    //Given
   //     Group group4 = new Group("Obuwie" );
   //     groupRepository.save(group4);
   //     Long id = group4.getId();
   //     //When
    //    Optional<Group> productsGroups = groupRepository.findById(id);
        //Then
    //    Assert.assertEquals(id, productsGroups.get().getId());
    //    //CleanUp
    //    groupRepository.deleteById(id);
    // }

    @Test
    public void testGroupRepositorySaveWithProduct(){
        //Given
        Group group = new Group ("Ubrania");
        Product product = new Product("Kurtka zimowa", "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus", (100), "1");
        product.setGroup(group);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        group.setProductList(productList);
        //When
        groupRepository.save(group);
        Long id = group.getId();
        int productListSize = group.getProductList().size();
        Optional<Group> productsGroups= groupRepository.findById(id);
        //Then
        Assert.assertEquals(id, productsGroups.get().getId());
        Assert.assertEquals(1,productListSize);
        Assert.assertEquals("Ubrania",  product.getGroup().getName());
        //CleanUp
        groupRepository.deleteById(id);

    }
}
