package com.systemdesign.service.impl;

import com.systemdesign.model.Agency;
import com.systemdesign.model.Cab;
import com.systemdesign.model.TaxiCategory;
import com.systemdesign.service.AgencyService;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AgencyServiceImpl implements AgencyService {

    Map<String, Agency> agencyMap;
    public AgencyServiceImpl(){
        this.agencyMap = new ConcurrentHashMap<>();
    }

    @Override
    public List<Cab> getAvailableCabs() {
        return null;
    }

    @Override
    public boolean bookCab(Cab cab) {
        return false;
    }

    @Override
    public double getExtimatedFare(Point a, Point b) {
        return 0;
    }

    @Override
    public int totalBookingOnCategory(String agencyID, TaxiCategory taxiCategory) {
        Agency agency = this.agencyMap.get(agencyID);
        return agency.getAllCompletedRides().size();
    }

    @Override
    public long getNumberOfVehiclesAvailable() {
        long count = this.agencyMap.entrySet().stream().map(Map.Entry::getValue).map(agency -> agency.getAllAvailableCabs())
                .count();
        return count;
    }

}
