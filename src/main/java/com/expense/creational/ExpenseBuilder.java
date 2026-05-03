package com.expense.creational;

import com.expense.model.Expense;
import java.time.LocalDate;

public class ExpenseBuilder {
    private double amount;
    private String description = "";
    private LocalDate date = LocalDate.now();
    private String categoryId;
    private String userId;
    private boolean isShared = false;

    public ExpenseBuilder setAmount(double amount) { this.amount = amount; return this; }
    public ExpenseBuilder setDescription(String description) { this.description = description; return this; }
    public ExpenseBuilder setDate(LocalDate date) { this.date = date; return this; }
    public ExpenseBuilder setCategoryId(String categoryId) { this.categoryId = categoryId; return this; }
    public ExpenseBuilder setUserId(String userId) { this.userId = userId; return this; }
    public ExpenseBuilder setShared(boolean shared) { this.isShared = shared; return this; }

    public Expense build() {
        Expense expense = new Expense(amount, description, date, categoryId, userId);
        expense.setShared(isShared);
        return expense;
    }
}
