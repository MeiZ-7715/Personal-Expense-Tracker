package com.expense.repositories;

import com.expense.model.Alert;
import java.util.List;

public interface AlertRepository extends Repository<Alert, String> {
    List<Alert> findByUserId(String userId);
    List<Alert> findByStatus(String status); // pending, triggered, dismissed, expired
}
