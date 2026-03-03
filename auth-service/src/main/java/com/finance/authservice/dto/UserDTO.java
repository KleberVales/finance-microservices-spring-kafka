package com.finance.authservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {

    private UUID id;
    private String username;
    private String email;
    private String passwordHash;
    private String role;


}
