package com.example.splitwise.splitwise;

import com.example.splitwise.splitwise.domain.ExpenseType;
import com.example.splitwise.splitwise.domain.User;
import com.example.splitwise.splitwise.domain.split.EqualSplit;
import com.example.splitwise.splitwise.domain.split.Split;
import com.example.splitwise.splitwise.service.ExpenseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SplitwiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
		System.out.println("Hello world!");
		User paidBy = new User("Babu", "userName", "phoneNo");
		double totalAmount = 1000;
		ExpenseType type = ExpenseType.EQUAL_SPLIT;

		User u1 = new User("srth12", "sarath", "abd");
		User u2 = new User("srth122", "sarathb", "abdd");

		Split split1 = new EqualSplit(u1, 200);
		Split split2 = new EqualSplit(u2, 700);
		Split split3 = new EqualSplit(paidBy, 100);
		List<Split> contribution = List.of(split1, split2, split3);


		ExpenseManager expenseManager = new ExpenseManager();
		expenseManager.userSpend(paidBy);
		expenseManager.addExpense(totalAmount, contribution, type, paidBy);
		expenseManager.showBalance(paidBy);
		expenseManager.userSpend(paidBy);
	}

}
