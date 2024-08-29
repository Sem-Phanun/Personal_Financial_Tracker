package com.project.personalfinancialmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email" , unique = true, nullable = false)
    private String email;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private Boolean status = true;

}
