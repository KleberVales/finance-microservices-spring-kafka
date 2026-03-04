package com.finance.authservice.controller;

import com.finance.authservice.dto.LoginRequestDTO;
import com.finance.authservice.dto.LoginResponseDTO;
import com.finance.authservice.dto.RegisterDTO;
import com.finance.authservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService registerService) {
        this.service = registerService;
    }


    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterDTO registerDTO) {


        return service.registerUser(registerDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO dto
    ) {

        return ResponseEntity.ok(service.login(dto));
    }

}
