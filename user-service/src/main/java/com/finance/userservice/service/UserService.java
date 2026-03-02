package com.finance.userservice.service;

import com.finance.userservice.domain.User;
import com.finance.userservice.dto.UserRegisterDTO;
import com.finance.userservice.exception.BusinessException;
import com.finance.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(UserRegisterDTO userRegisterDTO) {

        if (userRepository.existsByEmail(userRegisterDTO.getEmail())) {
            throw new BusinessException("Email already registered");
        }

        userRepository.save(new User(userRegisterDTO));

        return "User registered successfully";
    }

}
