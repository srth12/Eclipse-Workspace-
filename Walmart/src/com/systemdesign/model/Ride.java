package com.systemdesign.model;

import java.sql.Timestamp;

public class Ride extends Cab {

    private Timestamp startTime;
    private Timestamp endTime;
    private double totalFare;
    private User bookedUser;
    private RideStatus rideStatus;

    public Ride(String cabID, String vehicleNo, Driver driver, TaxiCategory taxiCategory) {
        super(cabID, vehicleNo, driver, taxiCategory);
        this.rideStatus = RideStatus.ACTIVE;
    }
    public void setStartTime(Timestamp startTime){
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime){
        this.endTime = endTime;
    }

    public void setTotalFare(double fare){
        this.totalFare = fare;
    }

    public void setRideStatus(RideStatus rideStatus){
        this.rideStatus = rideStatus;
    }

}
