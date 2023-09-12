package com.shop.now.ms.services.impl;

import com.shop.now.ms.models.dtos.UserDto;
import com.shop.now.ms.models.mappers.UserMapper;
import com.shop.now.ms.repositories.UserRepository;
import com.shop.now.ms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public Optional<UserDto> getUserByEmail(String email) {
        var result = userRepository.findByEmail(email).orElse(null);
        return Optional.ofNullable(userMapper.toUserDto(result));
    }
}
