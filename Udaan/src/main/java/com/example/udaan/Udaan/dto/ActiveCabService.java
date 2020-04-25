package com.example.udaan.Udaan.dto;

import com.example.udaan.Udaan.dao.cab.Cab;
import com.example.udaan.Udaan.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ActiveCabService {
    private Cab cab;
    private User user;
    private String bookingId;
}
