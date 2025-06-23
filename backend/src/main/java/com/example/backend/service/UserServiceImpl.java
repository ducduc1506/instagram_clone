package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.Entity.User;
import com.example.backend.dto.UserRequestDTO;
import com.example.backend.dto.UserResponseDTO;
import com.example.backend.exception.BadRequestException;
import com.example.backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Register a new user
    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        if (userRepository.existsByUsername(userRequestDTO.getUsername())) {
            throw new BadRequestException("Username already exists");
        }

        User user = new User();
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        String encodedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
        user.setPassword(encodedPassword);
        User saved = userRepository.save(user);

        return new UserResponseDTO(saved.getId(), saved.getUsername(), saved.getEmail(), saved.getAvatarUrl(), saved.getBio(), saved.getCreatedAt(), saved.getUpdatedAt());
    }

    // Login
    @Override
    public UserResponseDTO login(UserRequestDTO userRequestDTO) {
        User user = userRepository.findByEmailOrUsername(userRequestDTO.getEmail(), userRequestDTO.getUsername()).orElseThrow(() -> new BadRequestException("Email or Username does not exist"));

        if(!passwordEncoder.matches(userRequestDTO.getPassword(), user.getPassword())) {
            throw new BadRequestException("Password is incorrect");
        }

        return new UserResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getAvatarUrl(),
            user.getBio(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        );

    }

}
