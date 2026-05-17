package com.expense.services;

import com.expense.repositories.inmemory.InMemoryExpenseRepository;
import com.expense.repositories.inmemory.InMemoryBudgetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceTest {
    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        expenseService = new ExpenseService(
                new InMemoryExpenseRepository(),
                new InMemoryBudgetRepository()
        );
    }

    @Test
    void addExpensePositiveAmount() {
        var expense = expenseService.addExpense(100.0, "Lunch", LocalDate.now(), "cat1", "user1");
        assertEquals(100.0, expense.getAmount());
    }

    @Test
    void addExpenseZeroAmountThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> expenseService.addExpense(0, "Free", LocalDate.now(), "cat1", "user1"));
    }
}
