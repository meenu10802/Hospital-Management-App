package com.bridgelabz.hms.repository;

import com.bridgelabz.hms.entity.Role;
import com.bridgelabz.hms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ Used in login
    Optional<User> findByEmail(String email);

    // ✅ Used in register
    boolean existsByEmail(String email);

    // ✅ Optional
    List<User> findByRole(Role role);
}