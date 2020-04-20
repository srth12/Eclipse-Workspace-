package com.example.splitwise.splitwise.domain.split;

import com.example.splitwise.splitwise.domain.User;

public class PercentageSplit extends Split {

    private double percentage;


    public PercentageSplit(User user, double percentage) {
        super(user);
        this.percentage = percentage;
    }
}
