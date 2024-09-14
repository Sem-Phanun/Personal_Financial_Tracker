package com.project.personalfinancialmanagement.controller;

import com.project.personalfinancialmanagement.dto.UserDTO;
import com.project.personalfinancialmanagement.dto.UsernameDTO;
import com.project.personalfinancialmanagement.entity.User;
import com.project.personalfinancialmanagement.mapper.UserMapper;
import com.project.personalfinancialmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PutMapping("/deactivate/{userId}")
    public ResponseEntity<?> deactivateUser(@PathVariable Long userId) {
        userService.deactivateUser(userId);
        return ResponseEntity.ok("Account deactivated successfully.");
    }
    @PutMapping("/activate/{userId}")
    public ResponseEntity<?> activateUser(@PathVariable Long userId) {
        userService.activateUser(userId);
        return ResponseEntity.ok("Account activated successfully.");
    }

    @PutMapping("/changeName/{userId}")
    public ResponseEntity<?> changeName(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        User user =UserMapper.INSTANCE.toUser(userDTO);
        userService.changeName(userId, user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfileUser(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.getUser(userDetails.getUsername());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/changeUsername/{userId}")
    public ResponseEntity<?> changeUsername(@PathVariable Long userId, @RequestBody UsernameDTO usernameDTO) {
        User user = userService.changeUsername(userId, usernameDTO);
        return ResponseEntity.ok(user);
    }
}
