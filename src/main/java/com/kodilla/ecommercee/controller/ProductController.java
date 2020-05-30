package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(Long productId){
        return new ProductDto(1L,"kurtka zimowa", "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus lorem non auctor. Vivamus erat turpis, molestie a nisl non, scelerisque luctus enim. Nunc mi mi, laoreet ac mollis nec, pharetra sit amet tortor. Vivamus a bibendum purus.",
                100.00, 1L);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(Long productId){
        System.out.println("Deleting product id:" + productId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public ProductDto updateProduct(ProductDto productDto){
        return new ProductDto(1L, "Zmodyfikowana kurtka zimowa", "Opis kurtki", 125.00, 1L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public void createProduct(ProductDto productDto){
        System.out.println("Creating new product: " + productDto);
    }
}

