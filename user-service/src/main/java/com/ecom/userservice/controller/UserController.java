package com.ecom.userservice.controller;

import com.ecom.userservice.dto.UserDTO;
import com.ecom.userservice.dto.UserResponse;
import com.ecom.userservice.entity.User;
import com.ecom.userservice.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public UserResponse create(@RequestBody UserDTO user) {
        return userService.save(user, passwordEncoder);
    }

    @GetMapping
    public UserResponse getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public UserResponse delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
