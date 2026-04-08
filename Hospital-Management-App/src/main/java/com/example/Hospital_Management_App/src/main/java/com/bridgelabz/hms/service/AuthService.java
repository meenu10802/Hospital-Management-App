package com.bridgelabz.hms.service;

import com.bridgelabz.hms.config.JwtService;
import com.bridgelabz.hms.dto.AuthRequest;
import com.bridgelabz.hms.dto.AuthResponse;
import com.bridgelabz.hms.entity.Role;
import com.bridgelabz.hms.entity.User;
import com.bridgelabz.hms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    // ✅ Register
    public AuthResponse register(AuthRequest request) {

        // Check if email exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Create user
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // 🔥 encode
        user.setRole(Role.ADMIN); // or USER

        userRepository.save(user);

        return new AuthResponse(null, "User registered successfully");
    }

    // ✅ Login
    public AuthResponse login(AuthRequest request) {

        // Find user
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Generate JWT
        String token = jwtService.generateToken(user);

        return new AuthResponse(token, "Login successful");
    }
}