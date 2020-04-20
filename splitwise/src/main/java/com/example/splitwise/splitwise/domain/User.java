package com.example.splitwise.splitwise.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private final String userId;
    private String userName;
    private String phoneNo;

    public User(String userId, String userName, String phoneNo) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNo = phoneNo;
    }
}
