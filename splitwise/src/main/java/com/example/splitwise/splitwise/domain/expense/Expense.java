package com.example.splitwise.splitwise.domain.expense;

import com.example.splitwise.splitwise.domain.ExpenseType;
import com.example.splitwise.splitwise.domain.split.Split;
import com.example.splitwise.splitwise.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public abstract class Expense {
    private double totalAmount;
    private List<Split> splits;
    private User paidBy;
    private ExpenseType expenseType;

    public abstract boolean validate(List<Split> splits);
    public Expense(){}

}
