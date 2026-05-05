package com.expense.repositories;

import com.expense.model.SharedExpense;
import java.util.List;

public interface SharedExpenseRepository extends Repository<SharedExpense, String> {
    List<SharedExpense> findByOwnerId(String ownerId);
    List<SharedExpense> findBySharedWithId(String sharedWithId);
    List<SharedExpense> findByStatus(String status);
}
