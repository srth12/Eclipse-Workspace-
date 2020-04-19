package com.example.restservice.service.impl;

import com.example.restservice.dao.RegisteredUser;
import com.example.restservice.dao.User;
import com.example.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPortal {

    @Autowired
    private UserRepository userRepository;

    public User loginUser(User user){
        return new RegisteredUser(user.getUserId(), user.getName());
    }

    public User registerUser(String name, String userIdRequested){
        User user = new User(userIdRequested, name);
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserDetails(String userId){
        return new RegisteredUser(userId, "Dfd");
    }
}
