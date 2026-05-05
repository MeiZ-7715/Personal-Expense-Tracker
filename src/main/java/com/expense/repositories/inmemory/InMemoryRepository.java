package com.expense.repositories.inmemory;

import java.util.*;

public abstract class InMemoryRepository<T, ID> {
    protected final Map<ID, T> storage = new HashMap<>();

    public void save(ID id, T entity) {
        storage.put(id, entity);
    }

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void delete(ID id) {
        storage.remove(id);
    }
}
