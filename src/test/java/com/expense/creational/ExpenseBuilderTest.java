package com.expense.creational;

import com.expense.model.Expense;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseBuilderTest {
    @Test
    void testBuildExpenseWithAllFields() {
        Expense expense = new ExpenseBuilder()
                .setAmount(250.0)
                .setDescription("Checkers")
                .setDate(LocalDate.of(2026, 4, 22))
                .setCategoryId("cat1")
                .setUserId("user1")
                .setShared(true)
                .build();
        assertEquals(250.0, expense.getAmount());
        assertEquals("Checkers", expense.getDescription());
        assertTrue(expense.isShared());
    }
    @Test
    void testBuildExpenseWithMissingDescription() {
        Expense expense = new ExpenseBuilder()
                .setAmount(100.0)
                .setCategoryId("cat2")
                .setUserId("user1")
                .build();
        assertEquals("", expense.getDescription());
    }
}
