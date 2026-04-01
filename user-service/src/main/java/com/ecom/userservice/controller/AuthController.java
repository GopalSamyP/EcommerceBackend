package com.ecom.userservice.controller;

import com.ecom.userservice.dto.AuthResponse;
import com.ecom.userservice.dto.LoginRequest;
import com.ecom.userservice.dto.RegisterRequest;
import com.ecom.userservice.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {

        String token = authService.login(
                request.getUsername(),
                request.getPassword());

        return new AuthResponse(token);
    }

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {

        String token = authService.registerAndReturnToken(request);

        return new AuthResponse(token);
    }
}
