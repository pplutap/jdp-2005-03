package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getGroupId()
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getGroupId()
        );
    }

    public List<ProductDto> mapProductsListToProductDtoList(final List<Product> productsList) {
        return productsList.stream()
                .map(t -> new ProductDto(t.getId(), t.getName(), t.getDescription(), t.getPrice(), t.getGroupId()))
                .collect(Collectors.toList());
    }
}
