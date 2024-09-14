package com.project.personalfinancialmanagement.service;

import com.project.personalfinancialmanagement.dto.AuthLoginDTO;
import com.project.personalfinancialmanagement.dto.AuthRegisterDTO;
import com.project.personalfinancialmanagement.entity.User;
import com.project.personalfinancialmanagement.security.jwt.LoginResponse;

public interface AuthService {
    LoginResponse login(AuthLoginDTO authLoginDTO);
    User register(AuthRegisterDTO authRegisterDTO);
}
