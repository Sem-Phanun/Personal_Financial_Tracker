package com.project.personalfinancialmanagement.controller;

import com.project.personalfinancialmanagement.dto.ChangeNameDTO;
import com.project.personalfinancialmanagement.dto.UserDTO;
import com.project.personalfinancialmanagement.entity.User;
import com.project.personalfinancialmanagement.mapper.UserMapper;
import com.project.personalfinancialmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toUser(userDTO);
        userService.createUser(user);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/deactivate/user/{userId}")
    public ResponseEntity<?> deactivatedUser(@PathVariable Long userId) {
        userService.deactivateUser(userId);
        return ResponseEntity.ok("Account deactivated successfully.");
    }

    @PutMapping("/activate/user/{userId}")
    public ResponseEntity<?> activatedUser(@PathVariable Long userId) {
        userService.activateUser(userId);
        return ResponseEntity.ok("Account activated successfully.");
    }
    @PutMapping("/user/updateUsername/{userId}")
    public ResponseEntity<?> updateUsername(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toUser(userDTO);
        userService.updateUser(userId, user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user/changeName/{userId}")
    public ResponseEntity<?> changeName(@PathVariable Long userId, @RequestBody ChangeNameDTO changeNameDTO) {
        User user = userService.getUserById(userId);
        userService.changeName(userId, changeNameDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
