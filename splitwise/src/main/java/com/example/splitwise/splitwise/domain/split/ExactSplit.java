package com.example.splitwise.splitwise.domain.split;

import com.example.splitwise.splitwise.domain.User;

public class ExactSplit extends Split {
    public ExactSplit(User user, double amount) {
        super(user, amount);
    }
}
