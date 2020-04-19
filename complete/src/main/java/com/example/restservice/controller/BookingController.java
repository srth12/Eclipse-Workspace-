package com.example.restservice.controller;

import com.example.restservice.dao.Cab;
import com.example.restservice.dao.RegisteredUser;
import com.example.restservice.dao.User;
import com.example.restservice.dto.BookingRequest;
import com.example.restservice.dto.Status;
import com.example.restservice.service.impl.BookingPlatform;
import com.example.restservice.service.impl.ManageBooking;
import com.example.restservice.service.impl.UserPortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cab")
public class BookingController {

    @Autowired
    private BookingPlatform bookingPlatform;

    @Autowired
    private UserPortal userPortal;

    @GetMapping("/bookCabDummy")
    public String bookCab(@RequestParam(name = "amount") float amount, @RequestParam(name = "paymentType") String pt){
        return "Success";
    }

    @PostMapping("/bookCab")
    public ResponseEntity<Cab> bookCab(@RequestBody BookingRequest bookingRequest){
        User userDetails = userPortal.getUserDetails(bookingRequest.getUserId());
        Cab cabBooked = bookingPlatform.bookCab(userDetails, bookingRequest);
        return ResponseEntity.ok(cabBooked);
    }

    @PostMapping("/cancelCab")
    public ResponseEntity<Status> cancelCab(@RequestBody User user){
        Status status = bookingPlatform.cancelBooking(null, null);

        return ResponseEntity.ok(status);
    }

    @PostMapping("/test")
    public String testPost(){
        return "Testing successful";
    }
}
