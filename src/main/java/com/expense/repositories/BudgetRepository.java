package com.expense.repositories;

import com.expense.model.Budget;
import java.time.YearMonth;
import java.util.List;

public interface BudgetRepository extends Repository<Budget, String> {
    List<Budget> findByUserId(String userId);
    List<Budget> findByMonth(YearMonth month);
    Optional<Budget> findByUserAndCategoryAndMonth(String userId, String categoryId, YearMonth month);
}
