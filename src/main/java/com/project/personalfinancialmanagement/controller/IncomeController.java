package com.project.personalfinancialmanagement.controller;

import com.project.personalfinancialmanagement.dto.IncomeDTO;
import com.project.personalfinancialmanagement.entity.Income;
import com.project.personalfinancialmanagement.mapper.IncomeMapper;
import com.project.personalfinancialmanagement.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping("/income")
    public ResponseEntity<?> create(@RequestBody IncomeDTO incomeDTO) {
        Income income = IncomeMapper.INSTANCE.toIncome(incomeDTO);
        incomeService.createIncome(incomeDTO);
        return ResponseEntity.ok(income);
    }
}
