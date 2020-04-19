package com.example.restservice.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Driver extends User {

    @Getter @Setter
    private String cabId;

}
