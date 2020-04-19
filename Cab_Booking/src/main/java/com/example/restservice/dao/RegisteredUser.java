package com.example.restservice.dao;

import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.util.List;

@SuperBuilder
//@Entity(name = "registered_user")
public class RegisteredUser extends User {

    protected RegisteredUser(){
    }

    public RegisteredUser(String userId, String name) {
        super(userId, name);
    }

}
