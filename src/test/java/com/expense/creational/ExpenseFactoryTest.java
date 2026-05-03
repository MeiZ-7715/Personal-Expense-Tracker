package com.expense.creational;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseFactoryTest {
    @Test
    void testCreateGroceryExpense() {
        IExpense expense = ExpenseFactory.createExpense("grocery", 150.0, "Woolworths", LocalDate.now(), "cat1", "user1");
        assertTrue(expense instanceof GroceryExpense);
        expense.describe();
    }
    @Test
    void testCreateTransportExpense() {
        IExpense expense = ExpenseFactory.createExpense("transport", 50.0, "Uber", LocalDate.now(), "cat2", "user1");
        assertTrue(expense instanceof TransportExpense);
    }
    @Test
    void testUnknownTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ExpenseFactory.createExpense("unknown", 10, "test", LocalDate.now(), "cat", "user");
        });
    }
}
