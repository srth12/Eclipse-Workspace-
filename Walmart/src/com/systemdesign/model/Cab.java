package com.systemdesign.model;

public class Cab {
    private final String cabID;
    private final String vehicleNo;
    private Driver driver;
    private TaxiCategory taxiCategory;

    public Cab(String cabID, String vehicleNo, Driver driver, TaxiCategory taxiCategory) {
        this.cabID = cabID;
        this.vehicleNo = vehicleNo;
        this.driver = driver;
        this.taxiCategory = taxiCategory;
    }

    public TaxiCategory taxiCategory(){
        return this.taxiCategory;
    }
}
