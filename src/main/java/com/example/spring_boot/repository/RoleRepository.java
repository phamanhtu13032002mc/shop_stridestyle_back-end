package com.example.spring_boot.repository;

import java.util.Optional;

import com.example.spring_boot.model.ERole;
import com.example.spring_boot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
