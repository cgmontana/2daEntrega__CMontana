package uy.com.coolsoft.coderhouse.salesapp5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.com.coolsoft.coderhouse.salesapp5.models.Category;
import uy.com.coolsoft.coderhouse.salesapp5.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(categoryDetails.getName());
            category.toString();
            return categoryRepository.save(category);
        }).orElseGet(() -> {
            categoryDetails.setId(id);
            return categoryRepository.save(categoryDetails);
        });
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

