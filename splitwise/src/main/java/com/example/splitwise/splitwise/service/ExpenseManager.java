package com.example.splitwise.splitwise.service;

import com.example.splitwise.splitwise.domain.ExpenseType;
import com.example.splitwise.splitwise.domain.User;
import com.example.splitwise.splitwise.domain.expense.Expense;
import com.example.splitwise.splitwise.domain.split.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {

    private Map<String, User> userList;
    private List<Expense> expenseList;
    private Map<String, Map<String, Double>> balanceSheet;

    public ExpenseManager(){
        userList = new HashMap<>();
        expenseList = new ArrayList<>();
        balanceSheet = new HashMap<String, Map<String, Double>>();
    }

    public void userSpend(User user){
        Map<String, Double> ownSpend = balanceSheet.getOrDefault(user.getUserId(), new HashMap<>());
        System.out.println("Own spend is "+ ownSpend.getOrDefault(user.getUserId(), 0.0));
    }

    public void addExpense(double totalAmount, List<Split> splits, ExpenseType expenseType, User paidBy){
        Expense expense = ExpenseService.addExpense(totalAmount, splits, paidBy, expenseType);
        expenseList.add(expense);
        Map<String, Double> balancePayedBy = balanceSheet.getOrDefault(paidBy.getUserId(), new HashMap<>());

        splits.stream().forEach((Split split) -> {
            var paidTo = split.getUser();
            Double paidToBalance = balancePayedBy.getOrDefault(paidTo.getUserId(), 0.0);
            balancePayedBy.put(paidTo.getUserId(), paidToBalance + split.getAmount());
            balanceSheet.put(paidBy.getUserId(), balancePayedBy);

            if(split.getUser().getUserId() == paidBy.getUserId())
                return;

            Map<String, Double> users = balanceSheet.getOrDefault(paidTo.getUserId(), new HashMap<>());
            Double amount = users.getOrDefault(paidBy.getUserId(), 0.0);
            users.put(paidBy.getUserId(), amount - split.getAmount());
            balanceSheet.put(paidTo.getUserId(), users);

        });
    }

    public void showBalance(User user){
        String userId = user.getUserId();
        Map<String, Double> paidList = balanceSheet.get(userId);
        paidList.entrySet().stream().forEach(userExpense -> {
            System.out.println(userId + " Paid " + userExpense.getKey() + " " + userExpense.getValue() );
        });
    }

}
