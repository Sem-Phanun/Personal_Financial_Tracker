package com.project.personalfinancialmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class IncomeDTO {
    @DecimalMin(value = "0.000001", message = "Amount must be greater than 0")
    private BigDecimal amount;
    private String source;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime incomeDate;
    private Long userId;

}
