package com.example.udaan.Udaan.dao.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public abstract class User {

    private String userId;
    private String name;
    private String phoneNo;
    private UserLocation userLocation;

    public User(){}

    public User(String userId, String name, String phoneNo){
        this.userId = userId;
        this.name = name;
        this.phoneNo = phoneNo;
    }
}
