package com.project.personalfinancialmanagement.mapper;

import com.project.personalfinancialmanagement.dto.ExpenseDTO;
import com.project.personalfinancialmanagement.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseMapper {
    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    Expense toExpense(ExpenseDTO expenseDTO);

    ExpenseDTO toExpenseDTO(Expense expense);
}
