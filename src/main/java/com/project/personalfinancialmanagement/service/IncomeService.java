package com.project.personalfinancialmanagement.service;

import com.project.personalfinancialmanagement.dto.IncomeDTO;
import com.project.personalfinancialmanagement.entity.Income;

import java.util.List;

public interface IncomeService {
    Income createIncome(IncomeDTO incomeDTO);
    List<Income> getAllIncomes();
}
