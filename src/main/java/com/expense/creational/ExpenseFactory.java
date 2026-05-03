package com.expense.creational;

import com.expense.model.Expense;
import java.time.LocalDate;

interface IExpense { void describe(); }

class GroceryExpense extends Expense implements IExpense {
    public GroceryExpense(double amount, String description, LocalDate date, String categoryId, String userId) {
        super(amount, description, date, categoryId, userId);
    }
    public void describe() { System.out.println("Grocery expense: " + getAmount() + " ZAR"); }
}

class TransportExpense extends Expense implements IExpense {
    public TransportExpense(double amount, String description, LocalDate date, String categoryId, String userId) {
        super(amount, description, date, categoryId, userId);
    }
    public void describe() { System.out.println("Transport expense: " + getAmount() + " ZAR"); }
}

public class ExpenseFactory {
    public static IExpense createExpense(String type, double amount, String description, LocalDate date, String categoryId, String userId) {
        if ("grocery".equalsIgnoreCase(type))
            return new GroceryExpense(amount, description, date, categoryId, userId);
        else if ("transport".equalsIgnoreCase(type))
            return new TransportExpense(amount, description, date, categoryId, userId);
        else throw new IllegalArgumentException("Unknown expense type: " + type);
    }
}
