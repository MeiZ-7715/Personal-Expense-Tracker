package com.expense.repositories.inmemory;

import com.expense.model.Budget;
import com.expense.repositories.BudgetRepository;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryBudgetRepository extends InMemoryRepository<Budget, String> implements BudgetRepository {
    @Override
    public void save(Budget budget) {
        super.save(budget.getBudgetId(), budget);
    }

    @Override
    public Optional<Budget> findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<Budget> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(String id) {
        super.delete(id);
    }

    @Override
    public List<Budget> findByUserId(String userId) {
        return storage.values().stream()
                .filter(b -> b.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Budget> findByMonth(YearMonth month) {
        return storage.values().stream()
                .filter(b -> b.getMonth().equals(month))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Budget> findByUserAndCategoryAndMonth(String userId, String categoryId, YearMonth month) {
        return storage.values().stream()
                .filter(b -> b.getUserId().equals(userId) && b.getCategoryId().equals(categoryId) && b.getMonth().equals(month))
                .findFirst();
    }
}
