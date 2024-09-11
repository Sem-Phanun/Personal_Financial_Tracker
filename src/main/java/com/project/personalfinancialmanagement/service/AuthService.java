package com.project.personalfinancialmanagement.service;

import com.project.personalfinancialmanagement.dto.AuthRegisterDTO;
import com.project.personalfinancialmanagement.entity.User;

public interface AuthService {
    User login(String username, String password);
    User register(AuthRegisterDTO authRegisterDTO);
}
