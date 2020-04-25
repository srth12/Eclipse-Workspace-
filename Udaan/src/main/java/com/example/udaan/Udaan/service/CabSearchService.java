package com.example.udaan.Udaan.service;

import com.example.udaan.Udaan.dao.cab.Cab;
import com.example.udaan.Udaan.dao.user.UserLocation;

import java.util.Map;


public interface CabSearchService {

    public Cab getNearestCab(UserLocation location, Map<Boolean, Map<String, Cab>> availableCabs);
}
