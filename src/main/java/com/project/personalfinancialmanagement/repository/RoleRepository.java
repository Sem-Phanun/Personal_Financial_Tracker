package com.project.personalfinancialmanagement.repository;

import com.project.personalfinancialmanagement.entity.Role;
import com.project.personalfinancialmanagement.util.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(RoleEnum role);
}
