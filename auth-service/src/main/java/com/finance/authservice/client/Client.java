package com.finance.authservice.client;

import com.finance.authservice.dto.RegisterDTO;
import com.finance.authservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="user-serivce", url="${user.service.url}")
public interface Client {

    @PostMapping("/user/register")
    String registerUser(@RequestBody RegisterDTO registerDTO);

    @GetMapping("/user/login/{email}")
    UserDTO login(@PathVariable String email);

}
