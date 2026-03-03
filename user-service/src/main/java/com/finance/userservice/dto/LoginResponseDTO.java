package com.finance.userservice.dto;

import com.finance.userservice.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LoginResponseDTO {

    private UUID id;
    private String username;
    private String email;
    private String passwordHash;
    private String role;

    public LoginResponseDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.passwordHash = user.getPasswordHash();
        this.role = user.getRole().toString();
    }
}
