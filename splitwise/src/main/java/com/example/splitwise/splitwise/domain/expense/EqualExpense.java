package com.example.splitwise.splitwise.domain.expense;

import com.example.splitwise.splitwise.domain.ExpenseType;
import com.example.splitwise.splitwise.domain.User;
import com.example.splitwise.splitwise.domain.split.EqualSplit;
import com.example.splitwise.splitwise.domain.split.Split;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Predicate;


@AllArgsConstructor
public class EqualExpense extends Expense {

    Predicate<Split> equalExpencePredicate = split -> {
        if(split instanceof EqualSplit){
            return true;
        }else return false;
    };

    public EqualExpense(double totalAmount, List<Split> splits, User paidBy, ExpenseType expenseType) {
        super(totalAmount, splits, paidBy, expenseType);
    }

    @Override
    public boolean validate(List<Split> splits) {
        int totalUsers = splits.size();
        return splits.stream().allMatch(equalExpencePredicate);
    }

}
