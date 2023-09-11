package com.shop.now.ms.services.impl;

import com.shop.now.ms.models.dtos.JwtAuthenticationDto;
import com.shop.now.ms.models.dtos.SignUpDto;
import com.shop.now.ms.models.dtos.SigninDto;
import com.shop.now.ms.models.dtos.UserDto;
import com.shop.now.ms.models.mappers.UserMapper;
import com.shop.now.ms.repositories.UserRepository;
import com.shop.now.ms.roles.Role;
import com.shop.now.ms.services.AuthenticationService;
import com.shop.now.ms.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @Override
    public JwtAuthenticationDto signup(SignUpDto request) {
        var user = UserDto.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        var userEntity = userMapper.toUserEntity(user);
        userRepository.save(userEntity);
        var jwt = jwtService.generateToken(userEntity);
        return JwtAuthenticationDto.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationDto signin(SigninDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationDto.builder().token(jwt).build();
    }
}
