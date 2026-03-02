package com.finance.userservice.dto;



import com.finance.userservice.domain.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserRegisterDTO {

    private UUID id;
    private String username;
    private String email;
    private String passwordHash;
    private Role role;

}
