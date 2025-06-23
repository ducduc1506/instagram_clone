package com.example.backend.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.UserRequestDTO;
import com.example.backend.dto.UserResponseDTO;
import com.example.backend.payload.ApiResponse;
import com.example.backend.service.UserService;
import com.example.backend.utils.ResponseUtil;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO createdUser = userService.createUser(userRequestDTO);
        return ResponseEntity.status(201).body(ResponseUtil.created("User created successfully", createdUser));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserResponseDTO>> login(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO loggedInUser = userService.login(userRequestDTO);
        return ResponseEntity.ok(ResponseUtil.ok("Login successfully", loggedInUser));
    }
}
    