package com.example.restservice.service.impl;

import com.example.restservice.dao.Cab;
import com.example.restservice.dao.DistanceDetails;
import com.example.restservice.dao.User;
import com.example.restservice.dto.Status;
import com.example.restservice.service.SearchCab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingPlatform {

    @Autowired
    private SearchCab searchCab;

    public Cab bookCab(User user, DistanceDetails distanceDetails){
        List<Cab> nearbyCabs = searchCab.getAllNearbyCabs(distanceDetails);
        Cab bookedCab = notifyAndBookCab(nearbyCabs);
        return bookedCab;
    }

    private Cab notifyAndBookCab(List<Cab> nearbyCabs){
        return nearbyCabs.get((int) Math.random() * nearbyCabs.size() );
    }

    public Status cancelBooking(User user, Cab cab){
        return Status.SUCCESS;
    }
}
