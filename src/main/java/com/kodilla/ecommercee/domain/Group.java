package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamedNativeQuery(
        name = "Product.getProductId",
        query = "SELECT * FROM PRODUCT WHERE GROUPID = ",
        resultClass = Product.class
)


@Entity
@Table(name = "PRODUCTS_GROUPS")

public class Group {

    private Long id;
    private String name;

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group() {
    }

    public Group(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List setProductList(List<Product> productList) {
        return productList;
    }
}
