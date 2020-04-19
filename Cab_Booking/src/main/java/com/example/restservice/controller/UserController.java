package com.example.restservice.controller;

import com.example.restservice.dao.User;
import com.example.restservice.service.impl.UserPortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserPortal userPortal;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user){
        return null;
    }

    /**
     *
     * @param user
     * @return
     * Format:
     * {
     *     "userId": "srth12",
     *     "name": "sarath"
     * }
     */
    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return ResponseEntity.ok(userPortal.registerUser(user.getName(), user.getUserId()));
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userPortal.getAllUsers());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<User> findById(@PathVariable Long employeeId) {
        return ResponseEntity.ok(null);
    }
}
