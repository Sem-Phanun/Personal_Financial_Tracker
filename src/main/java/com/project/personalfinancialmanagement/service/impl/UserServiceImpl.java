package com.project.personalfinancialmanagement.service.impl;

import com.project.personalfinancialmanagement.dto.UsernameDTO;
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


    @Override
    public void deactivateUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found", userId));
        user.setStatus(false);
        userRepository.save(user);
    }

    @Override
    public void activateUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found", userId));
        user.setStatus(true);
        userRepository.save(user);
    }

    @Override
    public User changeName(Long userId, User changeNameDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found", userId));
        if (Objects.equals(changeNameDTO.getFirstName(), "") || Objects.equals(changeNameDTO.getLastName(), "")) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "First Name and Last Name are required");
        }
        user.setFirstName(changeNameDTO.getFirstName());
        user.setLastName(changeNameDTO.getLastName());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found", userId));
        userRepository.delete(user);
    }

    @Override
    public User changePassword(Long userId, String oldPassword, String newPassword) {
        //@TODO implementation change Password
        return null;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found", userId));
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User changeUsername(Long userId, UsernameDTO changeUsernameDTO) {
        User user = getUserById(userId);
        user.setUsername(changeUsernameDTO.getUsername());
        return userRepository.save(user);
    }
}
