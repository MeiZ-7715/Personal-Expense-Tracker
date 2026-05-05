package com.expense.repositories;

import com.expense.model.Category;
import java.util.List;

public interface CategoryRepository extends Repository<Category, String> {
    List<Category> findByType(String type); // "default" or "custom"
}
