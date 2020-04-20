package com.example.splitwise.splitwise.service;

import com.example.splitwise.splitwise.domain.ExpenseType;
import com.example.splitwise.splitwise.domain.User;
import com.example.splitwise.splitwise.domain.expense.*;
import com.example.splitwise.splitwise.domain.split.Split;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    public static Expense addExpense(double totalAmount, List<Split> splits, User paidBy, ExpenseType expenseType){
        switch (expenseType){
            case EXACT_SPLIT:
                Expense exactExpense = new ExactExpense(totalAmount, splits, paidBy, expenseType);
                ExpenseEnum.EXCAT_EXPENSE.validate(totalAmount, splits, paidBy);
                return exactExpense;
            case PERCENTAGE_SPLIT:
                Expense percentageExpense = new PercentageExpense(totalAmount, splits, paidBy, expenseType);
                percentageExpense.validate(splits);
                return percentageExpense;
            case EQUAL_SPLIT:
                Expense equalExpense = new EqualExpense(totalAmount, splits, paidBy, expenseType);
                equalExpense.validate(splits);
                return equalExpense;
            default:
                throw new IllegalStateException("Unexpected value: " + expenseType);
        }
    }

}
