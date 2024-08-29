package com.project.personalfinancialmanagement.service.impl;

import com.project.personalfinancialmanagement.entity.Category;
import com.project.personalfinancialmanagement.exception.ApiException;
import com.project.personalfinancialmanagement.exception.ResourceNotFoundException;
import com.project.personalfinancialmanagement.repository.CategoryRepository;
import com.project.personalfinancialmanagement.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    @Override
    public Category create(Category category) {
        Optional<Category> validateCategory =
                categoryRepository.findByCategoryName(category.getCategoryName());
        if (validateCategory.isPresent()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Category "+ category.getCategoryName() +" already exist");
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
       return categoryRepository.findById(categoryId)
               .orElseThrow(()-> new ResourceNotFoundException("Category id = %d not found", categoryId));
    }

    @Override
    public Category update(Long categoryId ,Category category) {
        String text = "Category Id = %d not found".formatted(categoryId);
        Category categoryToUpdate = getCategoryById(categoryId);
        if (categoryToUpdate.getCategoryName() == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST,text);
        }
        categoryToUpdate.setCategoryName(category.getCategoryName());
        return categoryRepository.save(categoryToUpdate);
    }

    @Override
    public void delete(Long categoryId) {
        Category cat  = categoryRepository.findByCategoryId(categoryId);
        if(cat == null) {
            throw new ResourceNotFoundException("Category id = not found",categoryId);
        }
        categoryRepository.delete(cat);
    }
}
