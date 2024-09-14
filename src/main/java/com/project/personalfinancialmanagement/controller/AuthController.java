package com.project.personalfinancialmanagement.controller;

import com.project.personalfinancialmanagement.dto.AuthLoginDTO;
import com.project.personalfinancialmanagement.dto.AuthRegisterDTO;
import com.project.personalfinancialmanagement.entity.User;
import com.project.personalfinancialmanagement.security.jwt.LoginResponse;
import com.project.personalfinancialmanagement.service.AuthService;
import com.project.personalfinancialmanagement.service.JwtService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody AuthRegisterDTO authRegisterDTO) {
        User user = authService.register(authRegisterDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthLoginDTO authLoginDTO) {
        LoginResponse loginResponse = authService.login(authLoginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
