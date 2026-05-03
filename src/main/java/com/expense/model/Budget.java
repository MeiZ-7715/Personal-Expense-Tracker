package com.expense.model;

import java.time.YearMonth;
import java.util.UUID;

public class Budget {
    private String budgetId;
    private String categoryId;
    private String userId;
    private YearMonth month;
    private double amountLimit;
    private double spentAmount;

    public Budget(String categoryId, String userId, YearMonth month, double amountLimit) {
        this.budgetId = UUID.randomUUID().toString();
        this.categoryId = categoryId;
        this.userId = userId;
        this.month = month;
        this.amountLimit = amountLimit;
        this.spentAmount = 0.0;
    }

    public String getBudgetId() { return budgetId; }
    public String getCategoryId() { return categoryId; }
    public String getUserId() { return userId; }
    public YearMonth getMonth() { return month; }
    public double getAmountLimit() { return amountLimit; }
    public void setAmountLimit(double amountLimit) { this.amountLimit = amountLimit; }
    public double getSpentAmount() { return spentAmount; }
    public void setSpentAmount(double spentAmount) { this.spentAmount = spentAmount; }

    public void setBudget() { System.out.println("Budget set: " + amountLimit + " ZAR"); }
    public void updateSpent(double additional) { this.spentAmount += additional; }
    public boolean checkThreshold() { return spentAmount >= 0.8 * amountLimit; }
}
