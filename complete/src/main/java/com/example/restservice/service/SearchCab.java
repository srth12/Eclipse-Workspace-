package com.example.restservice.service;

import com.example.restservice.dao.Cab;
import com.example.restservice.dao.DistanceDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchCab {

    public List<Cab> getAllNearbyCabs(DistanceDetails gpsLocation);
}
