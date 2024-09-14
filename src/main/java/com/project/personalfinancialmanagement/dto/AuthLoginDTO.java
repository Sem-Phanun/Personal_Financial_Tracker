package com.project.personalfinancialmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AuthLoginDTO {
    @NotEmpty(message = "please input username or email")
    private String username;
    @NotEmpty(message = "password must be more than 6 character")
    private String password;
}
