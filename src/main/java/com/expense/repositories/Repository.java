package com.expense.repositories;

import java.util.List;
import java.util.Optional;

/**
 * Generic repository interface for CRUD operations.
 * @param <T>  entity type
 * @param <ID> type of the identifier (e.g., String, Long)
 */
public interface Repository<T, ID> {
    void save(T entity);                // Create or update
    Optional<T> findById(ID id);        // Read one
    List<T> findAll();                  // Read all
    void delete(ID id);                 // Delete by id
}
