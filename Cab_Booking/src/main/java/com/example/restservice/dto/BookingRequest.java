package com.example.restservice.dto;

import com.example.restservice.dao.DistanceDetails;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookingRequest extends DistanceDetails {
    public BookingRequest(String userId, String fromLatitude, String fromLongitude, String toLatitude, String toLongitude) {
        super(fromLatitude, fromLongitude, toLatitude, toLongitude);
        this.userId = userId;
    }

    private String userId;

}
