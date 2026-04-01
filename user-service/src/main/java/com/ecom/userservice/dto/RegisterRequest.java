package com.ecom.userservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterRequest extends UserDTO implements Serializable {
    @NotNull(message = "Role cannot be blank")
    private Role role;
}
