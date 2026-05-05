package com.expense.factories;

import com.expense.repositories.*;
import com.expense.repositories.inmemory.*;

public class RepositoryFactory {

    public static UserRepository getUserRepository(String storageType) {
        switch (storageType.toUpperCase()) {
            case "MEMORY":
                return new InMemoryUserRepository();
            case "DATABASE":
                // Future implementation: return new DatabaseUserRepository();
                throw new UnsupportedOperationException("Database repository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + storageType);
        }
    }

    public static ExpenseRepository getExpenseRepository(String storageType) {
        switch (storageType.toUpperCase()) {
            case "MEMORY":
                return new InMemoryExpenseRepository();
            case "DATABASE":
                throw new UnsupportedOperationException("Database repository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + storageType);
        }
    }

    public static CategoryRepository getCategoryRepository(String storageType) {
        switch (storageType.toUpperCase()) {
            case "MEMORY":
                return new InMemoryCategoryRepository();
            case "DATABASE":
                throw new UnsupportedOperationException("Database repository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + storageType);
        }
    }

    public static BudgetRepository getBudgetRepository(String storageType) {
        switch (storageType.toUpperCase()) {
            case "MEMORY":
                return new InMemoryBudgetRepository();
            case "DATABASE":
                throw new UnsupportedOperationException("Database repository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + storageType);
        }
    }

    public static AlertRepository getAlertRepository(String storageType) {
        switch (storageType.toUpperCase()) {
            case "MEMORY":
                return new InMemoryAlertRepository();
            case "DATABASE":
                throw new UnsupportedOperationException("Database repository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + storageType);
        }
    }

    public static SharedExpenseRepository getSharedExpenseRepository(String storageType) {
        switch (storageType.toUpperCase()) {
            case "MEMORY":
                return new InMemorySharedExpenseRepository();
            case "DATABASE":
                throw new UnsupportedOperationException("Database repository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + storageType);
        }
    }
}
