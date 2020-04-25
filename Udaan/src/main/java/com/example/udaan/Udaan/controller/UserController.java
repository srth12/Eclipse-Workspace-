package com.example.udaan.Udaan.controller;

import com.example.udaan.Udaan.dao.user.Driver;
import com.example.udaan.Udaan.dao.user.User;
import com.example.udaan.Udaan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception {

        try {
            return ResponseEntity.ok(userService.getUser(user.getUserId()));
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping("/update-user-location")
    public void updateUserLocation(@RequestBody User user) throws Exception {
        userService.updateLocation(user);
    }



    @PostMapping("/rider/signup")
    public ResponseEntity<Boolean> registerRider(@RequestBody User user){
        ;
        return ResponseEntity.ok(userService.registerUser(user.getUserId(), user.getName(),
                user.getPhoneNo(), ""));
    }

    @PostMapping("/driver/signup")
    public ResponseEntity<Boolean> registerDriver(@RequestBody Driver user){
        ;
        return ResponseEntity.ok(userService.registerUser(user.getUserId(), user.getName(),
                user.getPhoneNo(), user.getCabNo()));
    }


    }