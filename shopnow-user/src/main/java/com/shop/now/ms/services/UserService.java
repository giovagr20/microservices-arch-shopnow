package com.shop.now.ms.services;

import com.shop.now.ms.models.dtos.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService {
    UserDetailsService userDetailsService();

    Optional<UserDto> getUserByEmail(String email);
}
