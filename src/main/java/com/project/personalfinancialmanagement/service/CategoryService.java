package com.project.personalfinancialmanagement.service;

import com.project.personalfinancialmanagement.dto.CategoryDTO;
import com.project.personalfinancialmanagement.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category create(CategoryDTO categoryDTO);
    List<Category> getCategories();
    Category getCategoryById(Long categoryId);
    Category update(Long categoryId,Category category);
    void delete(Long categoryId);
}
