package com.example.splitwise.splitwise.domain.expense;

import com.example.splitwise.splitwise.domain.ExpenseType;
import com.example.splitwise.splitwise.domain.User;
import com.example.splitwise.splitwise.domain.split.PercentageSplit;
import com.example.splitwise.splitwise.domain.split.Split;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public class PercentageExpense extends Expense{
    Predicate<Split> percentageExpencePredicate = split -> {
        if(split instanceof PercentageSplit){
            return true;
        }else return false;
    };

    public PercentageExpense(double totalAmount, List<Split> splits, User paidBy, ExpenseType expenseType) {
        super(totalAmount, splits, paidBy, expenseType);
    }

    @Override
    public boolean validate(List<Split> splits) {
        return splits.stream().allMatch(percentageExpencePredicate);
    }
}
