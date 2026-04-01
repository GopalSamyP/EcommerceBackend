package com.ecom.userservice.repository;

import com.ecom.userservice.entity.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
    Optional<User> findByMobile(String mobile);

}
