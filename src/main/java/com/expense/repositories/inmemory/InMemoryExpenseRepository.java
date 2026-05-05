package com.expense.repositories.inmemory;

import com.expense.model.Expense;
import com.expense.repositories.ExpenseRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryExpenseRepository extends InMemoryRepository<Expense, String> implements ExpenseRepository {
    @Override
    public void save(Expense expense) {
        super.save(expense.getExpenseId(), expense);
    }

    @Override
    public Optional<Expense> findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<Expense> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(String id) {
        super.delete(id);
    }

    @Override
    public List<Expense> findByUserId(String userId) {
        return storage.values().stream()
                .filter(e -> e.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Expense> findByDateRange(LocalDate start, LocalDate end) {
        return storage.values().stream()
                .filter(e -> !e.getDate().isBefore(start) && !e.getDate().isAfter(end))
                .collect(Collectors.toList());
    }
}
