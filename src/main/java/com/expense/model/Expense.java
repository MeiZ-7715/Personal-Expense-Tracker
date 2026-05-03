package com.expense.model;

import java.time.LocalDate;
import java.util.UUID;

public class Expense {
    private String expenseId;
    private double amount;
    private String description;
    private LocalDate date;
    private String categoryId;
    private String userId;
    private boolean isShared;

    public Expense(double amount, String description, LocalDate date, String categoryId, String userId) {
        this.expenseId = UUID.randomUUID().toString();
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.categoryId = categoryId;
        this.userId = userId;
        this.isShared = false;
    }

    public String getExpenseId() { return expenseId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
    public String getUserId() { return userId; }
    public boolean isShared() { return isShared; }
    public void setShared(boolean shared) { isShared = shared; }

    public void save() { System.out.println("Expense saved: " + amount + " ZAR"); }
    public void edit(double newAmount, String newDescription, LocalDate newDate, String newCategoryId) {
        this.amount = newAmount; this.description = newDescription; this.date = newDate; this.categoryId = newCategoryId;
    }
    public void delete() { System.out.println("Expense deleted: " + expenseId); }
}
