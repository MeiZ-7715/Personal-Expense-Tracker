package com.expense.creational;

import com.expense.model.Budget;
import java.time.YearMonth;

public class BudgetPrototype {
    private Budget budget;
    public BudgetPrototype(Budget budget) { this.budget = budget; }
    public Budget cloneForNextMonth() {
        return new Budget(budget.getCategoryId(), budget.getUserId(), budget.getMonth().plusMonths(1), budget.getAmountLimit());
    }
}
