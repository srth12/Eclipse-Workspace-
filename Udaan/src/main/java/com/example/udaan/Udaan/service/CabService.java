package com.example.udaan.Udaan.service;

import com.example.udaan.Udaan.dao.cab.Cab;
import com.example.udaan.Udaan.dao.user.UserLocation;
import com.example.udaan.Udaan.service.impl.ShortestDistanceCab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CabService {

    @Autowired
    private CabSearchService cabSearchService;

    //false -> not available -> booked
    private Map<Boolean, Map<String, Cab>> availableCabs = new HashMap<>(); //<IS_cab_available, <CAB_NO, Cab>>

    public CabService(){
        this.cabSearchService = new ShortestDistanceCab();
        this.availableCabs.put(true, )
    }

    public Cab getNearestCab(UserLocation location){
        return cabSearchService.getNearestCab(location, availableCabs);
    }

    public void updateBookedCab(Cab cab){
        Map<String, Cab> availableCabsMap = availableCabs.getOrDefault(true, new HashMap<>());
        if (availableCabsMap.size() != 0){
            if (availableCabsMap.containsKey(cab.getCabNo())){
                availableCabsMap.remove(cab.getCabNo());

                Map<String, Cab> bookedCabMap = availableCabs.getOrDefault(false, new HashMap<>());
                bookedCabMap.put(cab.getCabNo(), cab);
            }
        }
    }

    public void completeCabBooking(Cab cab){
        Map<String, Cab> bookedCabMap = availableCabs.getOrDefault(false, new HashMap<>());
        Cab cab1 = bookedCabMap.remove(cab.getCabNo());
        availableCabs.put(false, bookedCabMap);
        cab1.setBooked(false);
        Map<String, Cab> availableCabsMap = availableCabs.getOrDefault(true, new HashMap<>());
        availableCabsMap.put(cab1.getCabNo(), cab1);
        availableCabs.put(true, availableCabsMap);

    }

}
