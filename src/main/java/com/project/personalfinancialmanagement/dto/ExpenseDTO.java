package com.project.personalfinancialmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ExpenseDTO {
    private String description;
    private String amount;
    @NotNull(message = "expense date can't be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH-mm:ss")
    private LocalDate expenseDate;
    private Long categoryId;
    private Long userId;

}
