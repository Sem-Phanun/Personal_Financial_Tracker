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

    @Override
    public User createUser(User user) {
        String text = "Username = %s and Email = %s".formatted(user.getUsername(), user.getEmail());
        if (userRepository.findByUsername(user.getUsername()) != null && userRepository.findByEmail(user.getEmail()) != null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, text);
        }
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new ApiException(HttpStatus.BAD_REQUEST,"Username = %s already exists".formatted(user.getUsername()));
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new ApiException(HttpStatus.BAD_REQUEST,"Email = %s already exists".formatted(user.getEmail()));
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId,User user) {
        String text = "Username = %s Already exist".formatted(user);
        User userUpdateInfo = getUserById(userId);
        if (!Objects.equals(userUpdateInfo.getUserId(), userId)) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User Id = %d not found".formatted(userId));
        }

        User usernameExists = userRepository.findByUsername(user.getUsername());
        if(usernameExists != null) {
            throw new ApiException(HttpStatus.BAD_REQUEST,"Username = %s Already exists".formatted(user.getUsername()));
        }

        userUpdateInfo.setUsername(user.getUsername());
        return userRepository.save(userUpdateInfo);
    }


    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", userId));
    }

    @Override
    public void deactivateUser(Long userId) {
        User user = getUserById(userId);
        user.setStatus(false);
        userRepository.save(user);
    }

    @Override
    public void activateUser(Long userId) {
        User user = getUserById(userId);
        user.setStatus(true);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = getUserById(userId);
        userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", userId));
        userRepository.delete(user);
    }

    @Override
    public User changeName(Long userId, ChangeNameDTO changeNameDTO) {
        User user = getUserById(userId);
        if (Objects.equals(changeNameDTO.getFirstName(), "") || Objects.equals(changeNameDTO.getLastName(), "")) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "First Name and Last Name are required");
        }
        user.setFirstName(changeNameDTO.getFirstName());
        user.setLastName(changeNameDTO.getLastName());
        return userRepository.save(user);
    }

    @Override
    public User changePassword(Long userId, String oldPassword, String newPassword) {
        /* @TODO Implementation change password later */
        return null;
    }

}
