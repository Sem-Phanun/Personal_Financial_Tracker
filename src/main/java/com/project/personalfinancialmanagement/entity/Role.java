package com.project.personalfinancialmanagement.entity;

import com.project.personalfinancialmanagement.util.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleEnum role;
}
