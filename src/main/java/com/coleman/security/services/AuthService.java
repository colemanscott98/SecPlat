package com.coleman.security.services;

import com.coleman.security.models.User;
import com.coleman.security.repositories.UserRepository;
import com.coleman.security.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(String email, String password) {

        User user = new User();

        user.setEmail(email);

        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);

        return jwtService.generateToken(user.getEmail());
    }
}