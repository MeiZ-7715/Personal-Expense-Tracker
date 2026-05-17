package com.expense.services;

import com.expense.model.User;
import com.expense.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String email, String passwordHash) {
        // Business rule: email must be unique
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already exists: " + email);
        }
        User user = new User(email, passwordHash);
        userRepository.save(user);
        return user;
    }

    public User getUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
