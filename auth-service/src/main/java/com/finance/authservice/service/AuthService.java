package com.finance.authservice.service;

import com.finance.authservice.client.Client;
import com.finance.authservice.config.SecurityPasswordConfig;
import com.finance.authservice.dto.LoginRequestDTO;
import com.finance.authservice.dto.LoginResponseDTO;
import com.finance.authservice.dto.RegisterDTO;
import com.finance.authservice.dto.UserDTO;
import com.finance.authservice.security.JwtTokenProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final Client client;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final SecurityPasswordConfig securityPasswordConfig;

    public AuthService(Client client, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, SecurityPasswordConfig securityPasswordConfig) {
        this.client = client;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.securityPasswordConfig = securityPasswordConfig;
    }


    public String registerUser(RegisterDTO registerDTO) {

        String passwordHash = securityPasswordConfig.getPasswordEncoder().encode(registerDTO.getPasswordHash());

        registerDTO.setPasswordHash(passwordHash);

        client.registerUser(registerDTO);

        return "success";

    }

    public LoginResponseDTO login(LoginRequestDTO dto) {


       UserDTO userDTO  = client.login(dto.getEmail());

        if (!passwordEncoder.matches(dto.getPassword(), userDTO.getPasswordHash())) {
            throw new BadCredentialsException("Credenciais inválidas");
        }

        String token = jwtTokenProvider.generateToken(
                userDTO.getEmail(),
                userDTO.getRole()
        );

        LoginResponseDTO response = new LoginResponseDTO();
        response.setToken(token);
        response.setExpiresIn(jwtTokenProvider.getExpiration());

        return response;
    }


}
