package com.example.udaan.Udaan.dao;

import com.example.udaan.Udaan.dao.cab.Cab;
import com.example.udaan.Udaan.dao.user.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter @Setter
public class BookedHistory {

    private User user;
    private Cab cab;
    private Timestamp startTime;
    private Timestamp endTime;
    private String bookingId;

    public BookedHistory(User user, Cab cab) {
        this.user = user;
        this.cab = cab;
        this.startTime = new Timestamp(System.currentTimeMillis());
    }
}
