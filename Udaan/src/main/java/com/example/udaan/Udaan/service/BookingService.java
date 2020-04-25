package com.example.udaan.Udaan.service;

import com.example.udaan.Udaan.dao.BookedHistory;
import com.example.udaan.Udaan.dao.cab.Cab;
import com.example.udaan.Udaan.dao.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private Map<String, Map<String, BookedHistory>> userBookedHistory = new HashMap<>();

    @Autowired
    private CabService cabService;

    public  BookingService(){
        this.cabService = new CabService();
    }

    @Autowired
    private UserService userService;

    public Cab bookCab(User user){
        Cab nearestCab = cabService.getNearestCab(user.getUserLocation());
        nearestCab.setBooked(true);
        BookedHistory bookedHistory = new BookedHistory(user, nearestCab);
        String bookingId = UUID.randomUUID().toString();
        bookedHistory.setBookingId(bookingId);

        Map<String, BookedHistory> bookedList = userBookedHistory.getOrDefault(user.getUserId(), new HashMap<>());

        bookedList.put(bookingId, bookedHistory);
        userBookedHistory.put(user.getUserId(), bookedList);
        cabService.updateBookedCab(nearestCab);
        return nearestCab;
    }

    public List<BookedHistory> getBookedHistory(User user){
        Map<String, BookedHistory> booledMap = userBookedHistory.get(user.getUserId());
        return booledMap.values().stream().collect(Collectors.toList());
    }

    public void completeBooking(User user, String bookingId){
        Map<String, BookedHistory> bookingList = userBookedHistory.get(user.getUserId());
        BookedHistory bookedHistory = bookingList.get(bookingId);
        bookedHistory.setEndTime(new Timestamp(System.currentTimeMillis()));
//        cabService.completeCabBooking()
    }
}
