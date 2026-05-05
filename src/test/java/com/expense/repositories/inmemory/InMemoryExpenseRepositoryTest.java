package com.expense.repositories.inmemory;

import com.expense.model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryExpenseRepositoryTest {
    private InMemoryExpenseRepository repository;
    private Expense expense;

    @BeforeEach
    void setUp() {
        repository = new InMemoryExpenseRepository();
        expense = new Expense(100.0, "Lunch", LocalDate.now(), "cat1", "user1");
    }

    @Test
    void testSaveAndFindById() {
        repository.save(expense);
        var found = repository.findById(expense.getExpenseId());
        assertTrue(found.isPresent());
        assertEquals(100.0, found.get().getAmount());
    }

    @Test
    void testFindByUserId() {
        repository.save(expense);
        List<Expense> expenses = repository.findByUserId("user1");
        assertEquals(1, expenses.size());
    }

    @Test
    void testFindByDateRange() {
        repository.save(expense);
        List<Expense> expenses = repository.findByDateRange(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertEquals(1, expenses.size());
    }
}
