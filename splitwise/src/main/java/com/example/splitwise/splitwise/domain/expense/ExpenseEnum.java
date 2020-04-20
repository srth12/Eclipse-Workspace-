package com.example.splitwise.splitwise.domain.expense;

import com.example.splitwise.splitwise.domain.User;
import com.example.splitwise.splitwise.domain.split.EqualSplit;
import com.example.splitwise.splitwise.domain.split.ExactSplit;
import com.example.splitwise.splitwise.domain.split.PercentageSplit;
import com.example.splitwise.splitwise.domain.split.Split;

import java.util.List;

public enum ExpenseEnum {

    EQUAL_EXPENSE {
        @Override
        public boolean validate(double totalAmount, List<Split> splits, User paidBy) {
            return splits.stream().allMatch(EqualSplit.class::isInstance);
        }
    },
    PERCENTAGE_EXPENSE{
        @Override
        public boolean validate(double totalAmount, List<Split> splits, User paidBy) {
            return splits.stream().allMatch(PercentageSplit.class::isInstance);
        }
    },
    EXCAT_EXPENSE{
        @Override
        public boolean validate(double totalAmount, List<Split> splits, User paidBy) {
            return splits.stream().allMatch(ExactSplit.class::isInstance);
        }
    };


    public abstract boolean validate(double totalAmount, List<Split> splits, User paidBy);
}
