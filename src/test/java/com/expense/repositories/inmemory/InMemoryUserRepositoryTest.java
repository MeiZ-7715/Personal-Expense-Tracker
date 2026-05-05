package com.expense.repositories.inmemory;

import com.expense.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryUserRepositoryTest {
    private InMemoryUserRepository repository;
    private User user;

    @BeforeEach
    void setUp() {
        repository = new InMemoryUserRepository();
        user = new User("test@example.com", "hashedPassword");
    }

    @Test
    void testSaveAndFindById() {
        repository.save(user);
        Optional<User> found = repository.findById(user.getUserId());
        assertTrue(found.isPresent());
        assertEquals(user.getEmail(), found.get().getEmail());
    }

    @Test
    void testFindAll() {
        repository.save(user);
        assertEquals(1, repository.findAll().size());
    }

    @Test
    void testDelete() {
        repository.save(user);
        repository.delete(user.getUserId());
        Optional<User> found = repository.findById(user.getUserId());
        assertFalse(found.isPresent());
    }

    @Test
    void testFindByEmail() {
        repository.save(user);
        Optional<User> found = repository.findByEmail("test@example.com");
        assertTrue(found.isPresent());
        assertEquals(user.getUserId(), found.get().getUserId());
    }
}
