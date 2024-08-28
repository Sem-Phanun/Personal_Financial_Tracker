package com.project.personalfinancialmanagement.repository;

import com.project.personalfinancialmanagement.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
}
