package com.example.restservice.service.impl;

import com.example.restservice.dao.Cab;
import com.example.restservice.dao.DistanceDetails;
import com.example.restservice.dao.Driver;
import com.example.restservice.dao.User;
import com.example.restservice.service.SearchCab;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public class SearchCabByAlgo1 implements SearchCab {

    @Override
    public List<Cab> getAllNearbyCabs(DistanceDetails gpsLocation) {
        User driver1 = Driver.builder().cabId("abcd").name("Dhanush").build();
        Cab cab1 = Cab.builder().cabNo("abcd").driver(driver1).build();
        return List.of(cab1);
    }
}
