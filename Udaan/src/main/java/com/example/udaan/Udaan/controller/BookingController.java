package com.example.udaan.Udaan.controller;

import com.example.udaan.Udaan.dao.BookedHistory;
import com.example.udaan.Udaan.dao.cab.Cab;
import com.example.udaan.Udaan.dao.user.User;
import com.example.udaan.Udaan.dto.ActiveCabService;
import com.example.udaan.Udaan.service.BookingService;
import com.example.udaan.Udaan.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CabService cabService;

    @PostMapping("/book-cab")
    public Cab bookCab(User user){
        return bookingService.bookCab(user);
    }

    @PostMapping("/booked-history")
    public List<BookedHistory> getBookedHistory(User user){
        return bookingService.getBookedHistory(user);
    }

    @PostMapping("complete-booking")
    public void completeBooking(ActiveCabService activeCabService){
        bookingService.completeBooking(activeCabService.getUser(), activeCabService.getBookingId());
    }

}
