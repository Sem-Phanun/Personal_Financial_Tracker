package com.project.personalfinancialmanagement.mapper;

import com.project.personalfinancialmanagement.dto.IncomeDTO;
import com.project.personalfinancialmanagement.entity.Income;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IncomeMapper {
    IncomeMapper INSTANCE = Mappers.getMapper(IncomeMapper.class);

    Income toIncome(IncomeDTO incomeDTO);

    IncomeDTO toIncomeDTO(Income income);
}
