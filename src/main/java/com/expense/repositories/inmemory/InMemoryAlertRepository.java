package com.expense.repositories.inmemory;

import com.expense.model.Alert;
import com.expense.repositories.AlertRepository;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryAlertRepository extends InMemoryRepository<Alert, String> implements AlertRepository {
    @Override
    public void save(Alert alert) {
        super.save(alert.getAlertId(), alert);
    }

    @Override
    public Optional<Alert> findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<Alert> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(String id) {
        super.delete(id);
    }

    @Override
    public List<Alert> findByUserId(String userId) {
        return storage.values().stream()
                .filter(a -> a.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Alert> findByStatus(String status) {
        return storage.values().stream()
                .filter(a -> a.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
