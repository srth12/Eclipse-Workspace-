package com.example.restservice.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
@SuperBuilder
public class Cab {

    @Id
    private final String cabNo;

    @Getter
    @Setter
    private User driver;

    public Cab(String cabNo, User driver) {
        this.cabNo = cabNo;
        this.driver = driver;
    }
}
