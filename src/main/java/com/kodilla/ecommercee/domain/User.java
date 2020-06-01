package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class User {

    private Long id;
    private String userName;
    private Boolean status;
    private Long userKey;

    public User() {
    }

    public User(Long id, String userName, Boolean status, Long userKey) {
        this.id = id;
        this.userName = userName;
        this.status = status;
        this.userKey = userKey;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getUserName() {
        return userName;
    }

    @Column(name = "STATUS")
    public Boolean getStatus() {
        return status;
    }

    @Column(name = "USER_KEY")
    public Long getUserKey() {
        return userKey;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setStatus(Boolean status) {
        this.status = status;
    }

    private void setUserKey(Long userKey) {
        this.userKey = userKey;
    }
}