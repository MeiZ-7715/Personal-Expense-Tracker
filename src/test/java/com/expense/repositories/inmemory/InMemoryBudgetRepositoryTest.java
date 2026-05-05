package com.expense.repositories.inmemory;

import com.expense.model.Budget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.YearMonth;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryBudgetRepositoryTest {
    private InMemoryBudgetRepository repository;
    private Budget budget;

    @BeforeEach
    void setUp() {
        repository = new InMemoryBudgetRepository();
        budget = new Budget("cat1", "user1", YearMonth.now(), 2000.0);
    }

    @Test
    void testSaveAndFindById() {
        repository.save(budget);
        Optional<Budget> found = repository.findById(budget.getBudgetId());
        assertTrue(found.isPresent());
        assertEquals(2000.0, found.get().getAmountLimit());
    }

    @Test
    void testFindByUserAndCategoryAndMonth() {
        repository.save(budget);
        Optional<Budget> found = repository.findByUserAndCategoryAndMonth("user1", "cat1", YearMonth.now());
        assertTrue(found.isPresent());
    }
}
