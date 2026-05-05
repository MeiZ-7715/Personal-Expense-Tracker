package com.expense.repositories.database;

import com.expense.model.User;
import com.expense.repositories.UserRepository;
import java.util.List;
import java.util.Optional;

public class DatabaseUserRepository implements UserRepository {
    // In a real implementation, you would use JDBC, JPA, or a connection pool.
    // For now, this is a placeholder to show the structure.

    @Override
    public void save(User user) {
        // TODO: INSERT or UPDATE in users table
        System.out.println("DatabaseUserRepository.save() - not yet implemented");
    }

    @Override
    public Optional<User> findById(String id) {
        // TODO: SELECT * FROM users WHERE user_id = ?
        System.out.println("DatabaseUserRepository.findById() - not yet implemented");
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        System.out.println("DatabaseUserRepository.findAll() - not yet implemented");
        return List.of();
    }

    @Override
    public void delete(String id) {
        System.out.println("DatabaseUserRepository.delete() - not yet implemented");
    }

    @Override
    public Optional<User> findByEmail(String email) {
        System.out.println("DatabaseUserRepository.findByEmail() - not yet implemented");
        return Optional.empty();
    }
}
