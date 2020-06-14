package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "PRODUCT")
public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;
    private Long groupId;

    public Product(String name, String description, double price, Long groupId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }

    public Product() {

    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    @NotNull
    @Column(name = "GROUP_ID")
    public Long getGroupId() {
        return groupId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

}
