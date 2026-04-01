package com.ecom.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {

    private Long id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "password cannot be blank")
    @Size(min = 4, message = "Password must be at least 4 characters long")
    private String password;
    @NotBlank(message = "Mobile number cannot be blank")
    @Size(min = 12, message = "Mobile number with country code must be at least 12 characters long")
    private String mobile;
    private String address;
}
