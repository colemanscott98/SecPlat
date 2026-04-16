package com.coleman.security.controllers;

import com.coleman.security.dto.LoginRequest;
import com.coleman.security.dto.RegisterRequest;
import com.coleman.security.models.User;
import com.coleman.security.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(
                    request.getEmail(),
                    request.getPassword()
        );
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return userService.login(
                request.getEmail(),
                request.getPassword()
        );
    }
}
