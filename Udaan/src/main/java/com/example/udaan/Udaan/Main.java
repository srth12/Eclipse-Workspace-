package com.example.udaan.Udaan;

import com.example.udaan.Udaan.dao.cab.Cab;
import com.example.udaan.Udaan.dao.user.RegisteredUser;
import com.example.udaan.Udaan.dao.user.User;
import com.example.udaan.Udaan.service.BookingService;
import com.example.udaan.Udaan.service.CabService;
import com.example.udaan.Udaan.service.UserService;

public class Main {

    public static void main(String[] args) {
        User user = new RegisteredUser("abc", "Sarath", "080");
        UserService userService = new UserService();
        userService.registerUser("abc", "Sarath", "080", "");

        userService.registerUser("driv","driv1", "444", "abc" );

        BookingService bookingService = new BookingService();
        Cab cab = bookingService.bookCab(user);
        System.out.println(cab.getCabNo());

    }
}
