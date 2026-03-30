package com.ecom.userservice.mapper;

import com.ecom.userservice.dto.UserDTO;
import com.ecom.userservice.dto.UserResponse;
import com.ecom.userservice.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserMapper {

    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setMobile(dto.getMobile());
        user.setAddress(dto.getAddress());
        return user;
    }

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setMobile(user.getMobile());
        dto.setAddress(user.getAddress());
        return dto;
    }

    public UserResponse toResponseDTO(User user) {
        UserResponse response = new UserResponse();
        response.setUser(toDTO(user));
        return response;
    }

    public UserResponse toResponse(List<User> users) {
        UserResponse response = new UserResponse();
        response.setUsers(new ArrayList<>());
        users.forEach(user -> response.getUsers().add(toDTO(user)));
        return response;
    }
}
