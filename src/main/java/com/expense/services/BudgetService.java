package com.expense.services;

import com.expense.model.Budget;
import com.expense.repositories.BudgetRepository;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget setBudget(String categoryId, String userId, String month, double amountLimit) {
        if (amountLimit <= 0) {
            throw new IllegalArgumentException("Budget limit must be > 0 ZAR");
        }
        Budget existing = budgetRepository.findByUserAndCategoryAndMonth(userId, categoryId, month)
                .orElse(null);
        if (existing != null) {
            existing.setAmountLimit(amountLimit);
            budgetRepository.save(existing);
            return existing;
        } else {
            Budget budget = new Budget(categoryId, userId, month, amountLimit);
            budgetRepository.save(budget);
            return budget;
        }
    }

    public List<Budget> getBudgetsByUser(String userId) {
        return budgetRepository.findByUserId(userId);
    }
}
