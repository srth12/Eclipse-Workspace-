package com.example.udaan.Udaan.dao.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Driver extends User {
    private String cabNo;
    private boolean isAvailable;

    public Driver(String userId, String name, String phoneNo) {
        super(userId, name, phoneNo);

    }
    public Driver(String userId, String name, String phoneNo, String vehicleNo) {
        super(userId, name, phoneNo);
        this.cabNo = vehicleNo;
    }
}
