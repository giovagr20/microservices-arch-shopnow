package com.shop.now.ms.controllers;

import com.shop.now.ms.models.dtos.JwtAuthenticationDto;
import com.shop.now.ms.models.dtos.SignUpDto;
import com.shop.now.ms.models.dtos.SigninDto;
import com.shop.now.ms.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationDto> signup(@RequestBody SignUpDto request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationDto> signin(@RequestBody SigninDto request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
