package com.project.personalfinancialmanagement.service.impl;

import com.project.personalfinancialmanagement.dto.ChangeNameDTO;
import com.project.personalfinancialmanagement.entity.User;
import com.project.personalfinancialmanagement.exception.ApiException;
import com.project.personalfinancialmanagement.exception.ResourceNotFoundException;
import com.project.personalfinancialmanagement.repository.UserRepository;
import com.project.personalfinancialmanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


}
