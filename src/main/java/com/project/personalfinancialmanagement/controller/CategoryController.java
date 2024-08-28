package com.project.personalfinancialmanagement.controller;

import com.project.personalfinancialmanagement.dto.CategoryDTO;
import com.project.personalfinancialmanagement.entity.Category;
import com.project.personalfinancialmanagement.mapper.CategoryMapper;
import com.project.personalfinancialmanagement.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = CategoryMapper.INSTANCE.toCategory(categoryDTO);
        categoryService.create(category);
        return ResponseEntity.ok(category);
    }
    @GetMapping("{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<?> updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDTO categoryDTO) {
        Category category = CategoryMapper.INSTANCE.toCategory(categoryDTO);
        categoryService.update(categoryId, category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        categoryService.delete(categoryId);
        return ResponseEntity.ok("categoryId: " + categoryId);
    }

    @GetMapping
    public ResponseEntity<?> getCategories() {
        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);

    }
}
