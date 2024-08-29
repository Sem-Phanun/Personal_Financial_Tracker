package com.project.personalfinancialmanagement.service;

import com.project.personalfinancialmanagement.dto.ChangeNameDTO;
import com.project.personalfinancialmanagement.entity.User;

public interface UserService {
    User createUser(User user);
    User updateUser(Long userId, User user);
    User getUserById(Long userId);
    User changeName(Long userId, ChangeNameDTO changeNameDTO);
    User changePassword(Long userId, String oldPassword, String newPassword);
    void deactivateUser(Long userId);
    void activateUser(Long userId);
    void deleteUser(Long userId);

}
