package com.kodilla.ecommercee.service;

import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private Long id;
    private String name;

    public GroupService(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GroupService() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
