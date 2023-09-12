package com.shop.now.ms.controllers;

import com.shop.now.ms.exceptions.NotFoundException;
import com.shop.now.ms.models.dtos.UserDto;
import com.shop.now.ms.services.JwtService;
import com.shop.now.ms.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Controller to handle all operation user")
public class UserController {
    private final JwtService jwtService;
    private final UserService userService;

    @Autowired
    public UserController(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @GetMapping("/{email}")
    @Operation(summary = "Endpoint to return user by email")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok()
                .body(userService.getUserByEmail(email).orElseThrow(NotFoundException::new));
    }

    @GetMapping("/external")
    @Operation(summary = "Endpoint to return message of login")
    public ResponseEntity<Boolean> isValidOperation() {
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
