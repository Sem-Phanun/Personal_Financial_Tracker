package com.project.personalfinancialmanagement.service.impl;

import com.project.personalfinancialmanagement.dto.AuthRegisterDTO;
import com.project.personalfinancialmanagement.entity.User;
import com.project.personalfinancialmanagement.mapper.AuthMapper;
import com.project.personalfinancialmanagement.repository.UserRepository;
import com.project.personalfinancialmanagement.service.AuthService;
import com.project.personalfinancialmanagement.util.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User register(AuthRegisterDTO authRegisterDTO) {
        User user = AuthMapper.INSTANCE.toAuthRegister(authRegisterDTO);
        user.setPassword(passwordEncoder.encode(authRegisterDTO.getPassword()));
        return userRepository.save(user);
    }
}
