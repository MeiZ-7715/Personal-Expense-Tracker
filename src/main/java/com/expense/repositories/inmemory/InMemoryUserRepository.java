package com.expense.repositories.inmemory;

import com.expense.model.User;
import com.expense.repositories.UserRepository;
import java.util.Optional;

public class InMemoryUserRepository extends InMemoryRepository<User, String> implements UserRepository {
    @Override
    public void save(User user) {
        super.save(user.getUserId(), user);
    }

    @Override
    public Optional<User> findById(String id) {
        return super.findById(id);
    }

    @Override
    public java.util.List<User> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(String id) {
        super.delete(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return storage.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }
}
