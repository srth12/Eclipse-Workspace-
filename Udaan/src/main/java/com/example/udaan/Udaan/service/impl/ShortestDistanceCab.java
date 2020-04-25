package com.example.udaan.Udaan.service.impl;

import com.example.udaan.Udaan.dao.cab.Cab;
import com.example.udaan.Udaan.dao.user.UserLocation;
import com.example.udaan.Udaan.service.CabSearchService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ShortestDistanceCab implements CabSearchService {
    @Override
    public Cab getNearestCab(UserLocation location, Map<Boolean, Map<String, Cab>> availableCabs) {
        Map<String, Cab> availableCabsMap = availableCabs.getOrDefault(true, new HashMap<>());
        Optional<Cab> cab = availableCabsMap.values().stream()
                .min((cabInternal, t1) -> getDistance(location, cabInternal.getDriver().getUserLocation()));
        return cab.get();
    }

    public int getDistance(UserLocation userLocation, UserLocation driverLocation){
        double userX = Double.parseDouble(userLocation.getLatitude());
        double driverX = Double.parseDouble(driverLocation.getLatitude());

        double userY = Double.parseDouble(userLocation.getLongitude());
        double driverY = Double.parseDouble(driverLocation.getLongitude());

        double numerator = Math.pow(userX - driverX, 2) + Math.pow(userY - driverY, 2);
        return (int) Math.sqrt(numerator);
    }
}
