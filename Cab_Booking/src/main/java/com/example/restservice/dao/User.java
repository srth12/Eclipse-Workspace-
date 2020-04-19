package com.example.restservice.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuperBuilder
//@MappedSuperclass
@ToString
@Entity(name = "user")
@AllArgsConstructor
public class User {

    protected User(){}

    @Getter
    @Id
    private String userId;

    @Getter
    private String name;
}
