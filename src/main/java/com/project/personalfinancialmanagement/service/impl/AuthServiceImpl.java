package com.project.personalfinancialmanagement.service.impl;

import com.project.personalfinancialmanagement.dto.AuthLoginDTO;
import com.project.personalfinancialmanagement.dto.AuthRegisterDTO;
import com.project.personalfinancialmanagement.entity.Role;
import com.project.personalfinancialmanagement.entity.User;
import com.project.personalfinancialmanagement.mapper.AuthMapper;
import com.project.personalfinancialmanagement.repository.RoleRepository;
import com.project.personalfinancialmanagement.repository.UserRepository;
import com.project.personalfinancialmanagement.security.jwt.LoginResponse;
import com.project.personalfinancialmanagement.service.AuthService;
import com.project.personalfinancialmanagement.service.JwtService;
import com.project.personalfinancialmanagement.util.RoleEnum;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;

    @Override
    public LoginResponse login(AuthLoginDTO authLoginDTO) {

        // Authenticate the user with the provided username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authLoginDTO.getUsername(), authLoginDTO.getPassword())
        );
        try {
            // Set the authentication context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Load user details from the username
            UserDetails userDetails = userDetailsService.loadUserByUsername(authLoginDTO.getUsername());

            // Retrieve the user from the repository
            User user = userRepository.findByUsername(userDetails.getUsername());

            // Validate if the user was found
            if (!user.getUsername().equals(authLoginDTO.getUsername())) {
                throw new UsernameNotFoundException("User not found with username: " + authLoginDTO.getUsername());
            }
            String token = jwtService.generateToken(userDetails);
            return new LoginResponse(user, token);
        }catch (Exception e) {
            throw new RuntimeException("Invalid login credentials", e);
        }

    }

    @Override
    public User register(AuthRegisterDTO authRegisterDTO) {
        // Map the AuthRegisterDTO to a User entity
        User user = AuthMapper.INSTANCE.toAuthRegister(authRegisterDTO);

        // Encode the user password
        user.setPassword(passwordEncoder.encode(authRegisterDTO.getPassword()));

        // Find the default role for the user
        Optional<Role> role = roleRepository.findByRole(RoleEnum.ROLE_USER);
        // Set the user's role and status
        user.setRole(Collections.singleton(role.get()));
        user.setStatus(true);
        return userRepository.save(user);
    }
}
