package com.expense.services;

import com.expense.model.Expense;
import com.expense.repositories.ExpenseRepository;
import com.expense.repositories.BudgetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final BudgetRepository budgetRepository;

    public ExpenseService(ExpenseRepository expenseRepository, BudgetRepository budgetRepository) {
        this.expenseRepository = expenseRepository;
        this.budgetRepository = budgetRepository;
    }

    public Expense addExpense(double amount, String description, LocalDate date,
                              String categoryId, String userId) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be > 0 ZAR");
        }
        Expense expense = new Expense(amount, description, date, categoryId, userId);
        expenseRepository.save(expense);

        // Update budget spent amount for that month
        String month = YearMonth.from(date).toString();
        budgetRepository.findByUserAndCategoryAndMonth(userId, categoryId, month)
                .ifPresent(budget -> {
                    budget.setSpentAmount(budget.getSpentAmount() + amount);
                    budgetRepository.save(budget);
                });
        return expense;
    }

    public List<Expense> getUserExpenses(String userId) {
        return expenseRepository.findByUserId(userId);
    }
}
