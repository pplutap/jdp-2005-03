package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS_GROUPS")

public class Group {

    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();

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

   @OneToMany(
           targetEntity = Product.class,
           mappedBy = "groupId",
           cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST},
           fetch = FetchType.LAZY
    )
    public List<Product> getProductList() {
        return productList;
}

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
