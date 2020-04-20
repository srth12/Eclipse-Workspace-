package com.example.splitwise.splitwise.domain.split;

import com.example.splitwise.splitwise.domain.User;
import lombok.Getter;

@Getter
public class EqualSplit extends Split {

    public EqualSplit(User user, double amount) {
        super(user, amount);
    }
}
