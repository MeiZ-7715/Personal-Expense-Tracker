package com.expense.repositories.inmemory;

import com.expense.model.Category;
import com.expense.repositories.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryCategoryRepository extends InMemoryRepository<Category, String> implements CategoryRepository {
    @Override
    public void save(Category category) {
        super.save(category.getCategoryId(), category);
    }

    @Override
    public Optional<Category> findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(String id) {
        super.delete(id);
    }

    @Override
    public List<Category> findByType(String type) {
        return storage.values().stream()
                .filter(c -> c.getType().equals(type))
                .collect(Collectors.toList());
    }
}
