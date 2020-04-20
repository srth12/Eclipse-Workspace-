package com.example.splitwise.splitwise.domain.expense;

import com.example.splitwise.splitwise.domain.ExpenseType;
import com.example.splitwise.splitwise.domain.User;
import com.example.splitwise.splitwise.domain.split.ExactSplit;
import com.example.splitwise.splitwise.domain.split.Split;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.function.Predicate;

@AllArgsConstructor
public class ExactExpense extends Expense {

    Predicate<Split> equalExpencePredicate = split -> {
        if(split instanceof ExactSplit){
            return true;
        }else return false;
    };

    public ExactExpense(double totalAmount, List<Split> splits, User paidBy, ExpenseType expenseType) {
        super(totalAmount, splits, paidBy, expenseType);
    }

    @Override
    public boolean validate(List<Split> splits) {
        return splits.stream().allMatch(equalExpencePredicate);
    }
}
