package com.finance.userservice.domain;

import com.finance.userservice.dto.UserRegisterDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    private String username;

    @Column(unique = true,  nullable = false)
    private String email;

    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(UserRegisterDTO userRegisterDTO) {
        this.username = userRegisterDTO.getUsername();
        this.email = userRegisterDTO.getEmail();
        this.passwordHash = userRegisterDTO.getPasswordHash();
        this.role = userRegisterDTO.getRole();
    }

    public User() {

    }
}
