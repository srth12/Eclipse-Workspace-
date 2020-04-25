package com.example.udaan.Udaan.dao.cab;

import com.example.udaan.Udaan.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Cab {

    private String cabNo;
    private CabType cabType;
    private User driver;
    private boolean isBooked;
}
