package com.project.personalfinancialmanagement.service.impl;

import com.project.personalfinancialmanagement.entity.Expense;
import com.project.personalfinancialmanagement.repository.ExpenseRepository;
import com.project.personalfinancialmanagement.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;


    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
}
