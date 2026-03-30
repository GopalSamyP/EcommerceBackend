package com.ecom.userservice.service;

import com.ecom.userservice.dto.UserDTO;
import com.ecom.userservice.dto.UserResponse;
import com.ecom.userservice.entity.User;
import com.ecom.userservice.mapper.UserMapper;
import com.ecom.userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repo,
                       UserMapper mapper,
                       PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse save(UserDTO userRequest) {
        User user = mapper.toEntity(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User userEntity = repo.save(user);
        return mapper.toResponseDTO(userEntity);
    }

    public UserResponse getAll() {
        List<User> users = repo.findAll();
        return mapper.toResponse(users);
    }

    public UserResponse getById(Long id) {
        User userEntity =  repo.findById(id).orElseThrow();
        return  mapper.toResponseDTO(userEntity);
    }

    public UserResponse delete(Long id) {
        repo.deleteById(id);
        return (UserResponse) UserResponse.builder()
                .message("User with id " + id + " deleted successfully")
                .build();
    }
}
