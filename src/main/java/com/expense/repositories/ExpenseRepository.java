package com.expense.repositories;

import com.expense.model.Expense;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends Repository<Expense, String> {
    List<Expense> findByUserId(String userId);
    List<Expense> findByDateRange(LocalDate start, LocalDate end);
}
