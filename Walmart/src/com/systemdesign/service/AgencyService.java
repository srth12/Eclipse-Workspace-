package com.systemdesign.service;

import com.systemdesign.model.Cab;
import com.systemdesign.model.TaxiCategory;

import java.awt.*;
import java.util.List;

public interface AgencyService {
    public List<Cab> getAvailableCabs();
    public boolean bookCab(Cab cab);
    public double getExtimatedFare(Point a, Point b);
    public int totalBookingOnCategory(String agencyID, TaxiCategory taxiCategory);
    public long getNumberOfVehiclesAvailable();
}
