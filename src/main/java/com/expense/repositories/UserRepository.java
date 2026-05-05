package com.expense.repositories;

import com.expense.model.User;

public interface UserRepository extends Repository<User, String> {
    // Additional methods specific to User, if needed
    Optional<User> findByEmail(String email);
}
