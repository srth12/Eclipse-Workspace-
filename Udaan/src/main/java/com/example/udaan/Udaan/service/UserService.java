package com.example.udaan.Udaan.service;

import com.example.udaan.Udaan.dao.user.Driver;
import com.example.udaan.Udaan.dao.user.RegisteredUser;
import com.example.udaan.Udaan.dao.user.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> riderList = new HashMap<>();
    private Map<String, User> driverList = new HashMap<>();

    public boolean registerUser(String userId, String userName, String phoneNo,
                             String vehicleNo){
        if (vehicleNo.length() > 0){
            User user = new Driver(userId, userName, phoneNo, vehicleNo);
            this.driverList.put(userId, user);
        }else {
            User user = new RegisteredUser(userId, userName, phoneNo);
            riderList.put(userId, user);
        }
        return true;
    }

    public User getUser(String userId) throws Exception {
        if (riderList.containsKey(userId)){
            return riderList.get(userId);
        }else if (driverList.containsKey(userId)){
            return driverList.get(userId);
        }else throw new  Exception("User not found");
    }

    public void updateLocation(User user) throws Exception {
        if (riderList.containsKey(user.getUserId())){
            riderList.put(user.getUserId(), user);
        }else if (driverList.containsKey(user.getUserId())){
            driverList.put(user.getUserId(), user);
        }else throw new Exception("Invalid user id");
    }

}
