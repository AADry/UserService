package com.example.userservice.service;

import com.example.userservice.dto.UserAuthDto;

public interface UserService {
    Boolean register(UserAuthDto user);
    Boolean login(UserAuthDto user);
}
