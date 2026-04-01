package com.ecom.userservice.service;

import com.ecom.userservice.dto.RegisterRequest;
import com.ecom.userservice.entity.User;
import com.ecom.userservice.mapper.UserMapper;
import com.ecom.userservice.repository.UserRepository;
import com.ecom.userservice.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public AuthService(UserRepository userRepository,
                       JwtUtil jwtUtil,
                       PasswordEncoder passwordEncoder,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public String login(String username, String password) {

        User user = userRepository.findByEmail(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(username);
    }

    public String registerAndReturnToken(@Valid RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()) != null) {
            throw new RuntimeException("Email already in use");
        }

        if (userRepository.findByMobile(request.getMobile()).isPresent()) {
            throw new RuntimeException("mobile already in use");
        }

        User user = userMapper.toEntity(request);
        user.setRole(request.getRole());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return jwtUtil.generateToken(request.getEmail());
    }
}
