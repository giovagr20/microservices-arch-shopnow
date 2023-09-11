package com.shop.now.ms.services;

import com.shop.now.ms.models.dtos.JwtAuthenticationDto;
import com.shop.now.ms.models.dtos.SignUpDto;
import com.shop.now.ms.models.dtos.SigninDto;

public interface AuthenticationService {
    JwtAuthenticationDto signup(SignUpDto request);

    JwtAuthenticationDto signin(SigninDto request);
}
