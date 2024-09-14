package com.project.personalfinancialmanagement.service;

import com.project.personalfinancialmanagement.dto.UsernameDTO;
import com.project.personalfinancialmanagement.entity.User;

public interface UserService {
    void deactivateUser(Long userId);
    void activateUser(Long userId);
    User changeName(Long userId, User changeNameDTO);
    void deleteUser(Long userId);
    User changePassword(Long userId, String oldPassword, String newPassword);
    User getUserById(Long userId);
    User getUser(String username);
    User changeUsername(Long userId, UsernameDTO usernameDTO);
}
