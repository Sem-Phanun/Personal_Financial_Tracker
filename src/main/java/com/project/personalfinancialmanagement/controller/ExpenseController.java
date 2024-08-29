package com.project.personalfinancialmanagement.controller;

import com.project.personalfinancialmanagement.dto.ExpenseDTO;
import com.project.personalfinancialmanagement.entity.Expense;
import com.project.personalfinancialmanagement.mapper.ExpenseMapper;
import com.project.personalfinancialmanagement.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        Expense expense = ExpenseMapper.INSTANCE.toExpense(expenseDTO);
        expense = expenseService.addExpense(expense);
        return ResponseEntity.ok(expense);
    }
}
