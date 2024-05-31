package org.example.services;

import org.example.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private List<Category> categories = new ArrayList<>();

    public CategoryService() {
        categories.add(new Category(1, "Социален живот"));
        categories.add(new Category(2, "Хапване"));
        categories.add(new Category(3, "Дом"));
        categories.add(new Category(4, "Животни"));
    }
    public List<Category> getCategories() {
        return categories;
    }
    public Category getCategoryById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
