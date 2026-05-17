package com.expense.api.dto;

public record BudgetDto(String budgetId, String categoryId, String userId,
                       String month, double amountLimit, double spentAmount) {}
