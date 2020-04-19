package com.example.restservice.service.impl;

import com.example.restservice.dao.Cab;
import com.example.restservice.dao.DistanceDetails;
import com.example.restservice.dao.Driver;
import com.example.restservice.dao.User;
import com.example.restservice.service.SearchCab;
import com.example.restservice.service.impl.Payment;
import com.example.restservice.service.impl.PaymentMethodTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ManageBooking {

    /**
     *
     * @return List of Cab that has booked previously
     */
    public List<Cab> getBookedHistory(){

        User driver1 = Driver.builder().cabId("abcd").name("Dhanush").build();
        Cab cab1 = Cab.builder().cabNo("abcd").driver(driver1).build();
        return List.of(cab1);
    }

}
