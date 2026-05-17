package com.expense.api.dto;

import java.time.LocalDate;

public record ExpenseDto(String expenseId, double amount, String description,
                        LocalDate date, String categoryId, String userId, boolean isShared) {}
