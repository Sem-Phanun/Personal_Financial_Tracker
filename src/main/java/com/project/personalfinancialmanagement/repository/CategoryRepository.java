package com.project.personalfinancialmanagement.repository;

import com.project.personalfinancialmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryName(String name);
    Category findByCategoryId(Long categoryId);
}
