package com.example.restservice.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
public class DistanceDetails {

    @Getter
    private final String fromLatitude;

    @Getter
    private final String fromLongitude;

    @Getter
    private final String toLatitude;

    @Getter
    private final String toLongitude;

    public DistanceDetails(String fromLatitude, String fromLongitude, String toLatitude, String toLongitude) {
        this.fromLatitude = fromLatitude;
        this.fromLongitude = fromLongitude;
        this.toLatitude = toLatitude;
        this.toLongitude = toLongitude;
    }
}
