package com.kodilla.ecommercee.domain;

import javax.persistence.*;

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "groupId")
    private String groupId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getGroupId() {
        return groupId;
    }

    public Cart() {
    }

    public Cart(String name, String description, double price, String groupId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }


}
