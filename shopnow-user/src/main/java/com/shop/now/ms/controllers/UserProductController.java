package com.shop.now.ms.controllers;

import com.shop.now.ms.services.AuthenticationService;
import com.shop.now.ms.services.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/users/products")
@Tag(name = "Controller to handle all operation products user")
public class UserProductController {
    private final JwtService jwtService;

    @Autowired
    public UserProductController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping
    @Operation(summary = "Endpoint to return message of login")
    public ResponseEntity<Boolean> isValidOperation() {
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
