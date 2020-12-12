package com.systemdesign.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public final class Agency {
    private final String agencyName;
    private final String agencyID;

    private List<Ride> bookedHistory;
    private Map<Timestamp, Ride> bookedHistoryByDate;

    //Active cabs where riding scheduled/in-progress
    private List<Cab> activeCabs;
    //Available cabs that can be booked
    private List<Cab> availableCabs;

    public Agency(String agencyName, String agencyID) {
        this.agencyName = agencyName;
        this.agencyID = agencyID;
        this.bookedHistory = new ArrayList<>();
        this.availableCabs = new ArrayList<>();
        this.activeCabs = new ArrayList<>();
    }

    public List<Ride> getAllCompletedRides(){
        return this.bookedHistory;
    }
    public List<Cab> getAllAvailableCabs(){
        return this.availableCabs;
    }

    public List<Ride> getAllCompletedRidesByCategory(TaxiCategory category){
        return this.bookedHistory.stream().filter(ride -> ride.taxiCategory() == category).collect(Collectors.toList());
    }

}
