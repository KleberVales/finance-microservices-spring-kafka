package com.finance.userservice.controller;

import com.finance.userservice.dto.LoginResponseDTO;
import com.finance.userservice.dto.UserRegisterDTO;
import com.finance.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        return userService.registerUser(userRegisterDTO);
    }

    @GetMapping("/login/{email}")
    public LoginResponseDTO findByEmail(@PathVariable String email) {

        return userService.loginUser(email);

    }

}
