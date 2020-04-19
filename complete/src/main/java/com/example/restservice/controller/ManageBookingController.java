package com.example.restservice.controller;

import com.example.restservice.dao.Cab;
import com.example.restservice.dao.User;
import com.example.restservice.service.impl.ManageBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller("/bookManager")
public class ManageBookingController {

    @Autowired
    private ManageBooking manageBooking;

    @PostMapping("/history")
    public ResponseEntity<List<Cab>> getBookingHistory(@RequestBody User user){
        return ResponseEntity.ok(manageBooking.getBookedHistory());
    }
}
