package com.project.personalfinancialmanagement.service.impl;

import com.project.personalfinancialmanagement.dto.CategoryDTO;
import com.project.personalfinancialmanagement.entity.Category;
import com.project.personalfinancialmanagement.entity.User;
import com.project.personalfinancialmanagement.exception.ApiException;
import com.project.personalfinancialmanagement.exception.ResourceNotFoundException;
import com.project.personalfinancialmanagement.mapper.CategoryMapper;
import com.project.personalfinancialmanagement.repository.CategoryRepository;
import com.project.personalfinancialmanagement.repository.UserRepository;
import com.project.personalfinancialmanagement.service.CategoryService;
import com.project.personalfinancialmanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final UserRepository userRepository;


    @Override
    public Category create(CategoryDTO categoryDTO) {
        User user = userRepository.findById(categoryDTO.getUserId())
                .orElseThrow(()-> new ApiException(HttpStatus.NOT_FOUND, "User Not Found"));
        Optional<Category> validateCategory =
                categoryRepository.findByCategoryName(categoryDTO.getCategoryName());
        if (validateCategory.isPresent()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Category "+ categoryDTO.getCategoryName() +" already exist");
        }
        Category category = categoryMapper.toCategory(categoryDTO);
        category.setUser(user);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
       return categoryRepository.findById(categoryId)
               .orElseThrow(()-> new ResourceNotFoundException("Category", categoryId));
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
            throw new ResourceNotFoundException("Category",categoryId);
        }
        categoryRepository.delete(cat);
    }
}
