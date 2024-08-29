package com.project.personalfinancialmanagement.service.impl;

import com.project.personalfinancialmanagement.dto.IncomeDTO;
import com.project.personalfinancialmanagement.entity.Income;
import com.project.personalfinancialmanagement.entity.User;
import com.project.personalfinancialmanagement.exception.ApiException;
import com.project.personalfinancialmanagement.mapper.IncomeMapper;
import com.project.personalfinancialmanagement.mapper.UserMapper;
import com.project.personalfinancialmanagement.repository.IncomeRepository;
import com.project.personalfinancialmanagement.repository.UserRepository;
import com.project.personalfinancialmanagement.service.IncomeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Income createIncome(IncomeDTO incomeDTO) {
        User user = userRepository.findById(incomeDTO.getUserId())
                .orElseThrow(()-> new ApiException(HttpStatus.NOT_FOUND, "User Not Found"));
        Income income = userMapper.toIncome(incomeDTO);
        income.setUser(user);
        if (income.getAmount() == null || income.getAmount().compareTo(BigDecimal.ZERO) <= 0){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Amount must be greater than 0");
        }
        if(income.getIncomeDate() == null){
            income.setIncomeDate(LocalDateTime.now());
        }
        return incomeRepository.save(income);
    }

    @Override
    public List<Income> getAllIncomes() {
        return List.of();
    }
}
