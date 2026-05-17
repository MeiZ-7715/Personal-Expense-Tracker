package com.expense.services;

import com.expense.model.User;
import com.expense.repositories.inmemory.InMemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(new InMemoryUserRepository());
    }

    @Test
    void createUserSuccess() {
        User user = userService.createUser("test@example.com", "hash");
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    void createUserDuplicateEmailThrows() {
        userService.createUser("duplicate@example.com", "hash");
        assertThrows(IllegalArgumentException.class,
                () -> userService.createUser("duplicate@example.com", "hash2"));
    }
}
