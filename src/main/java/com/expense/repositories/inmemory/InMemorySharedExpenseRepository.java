package com.expense.repositories.inmemory;

import com.expense.model.SharedExpense;
import com.expense.repositories.SharedExpenseRepository;
import java.util.List;
import java.util.stream.Collectors;

public class InMemorySharedExpenseRepository extends InMemoryRepository<SharedExpense, String> implements SharedExpenseRepository {
    @Override
    public void save(SharedExpense sharedExpense) {
        super.save(sharedExpense.getShareId(), sharedExpense);
    }

    @Override
    public Optional<SharedExpense> findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<SharedExpense> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(String id) {
        super.delete(id);
    }

    @Override
    public List<SharedExpense> findByOwnerId(String ownerId) {
        return storage.values().stream()
                .filter(s -> s.getOwnerId().equals(ownerId))
                .collect(Collectors.toList());
    }

    @Override
    public List<SharedExpense> findBySharedWithId(String sharedWithId) {
        return storage.values().stream()
                .filter(s -> s.getSharedWithId().equals(sharedWithId))
                .collect(Collectors.toList());
    }

    @Override
    public List<SharedExpense> findByStatus(String status) {
        return storage.values().stream()
                .filter(s -> s.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
