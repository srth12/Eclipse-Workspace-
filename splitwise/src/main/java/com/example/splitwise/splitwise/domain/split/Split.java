package com.example.splitwise.splitwise.domain.split;

import com.example.splitwise.splitwise.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Split{

    private final User user;
    private double amount;

    protected Split(User user) {
        this.user = user;
    }

}
