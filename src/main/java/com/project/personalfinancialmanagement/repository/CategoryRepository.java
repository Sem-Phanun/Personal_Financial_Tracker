package com.project.personalfinancialmanagement.repository;

import com.project.personalfinancialmanagement.entity.Category;
import com.project.personalfinancialmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.user.userId = :userId")
    List<Category> findCategoriesByUserId(@Param("userId")Long userId);
    Category findByCategoryId(Long categoryId);
}
