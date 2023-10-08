package com.example.userservice.controller;

import com.example.userservice.dto.UserAuthDto;
import com.example.userservice.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-service")
public class AuthController {

    private final UserServiceImpl userService;
    @PostMapping("/register")
    public ResponseEntity<Boolean> register(
            @RequestBody UserAuthDto user) {
        return ResponseEntity.ok(userService.register(user));
    }
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(
            @RequestBody UserAuthDto user) {
        return ResponseEntity.ok(userService.login(user));
    }

}
