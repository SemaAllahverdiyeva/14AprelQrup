package com.example.userservice.service;

import org.springframework.stereotype.Service;

import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.response.UserComputerResponse;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ComputerClient computerClient;

    public UserService(
            UserRepository userRepository,
            ComputerClient computerClient) {

        this.userRepository = userRepository;
        this.computerClient = computerClient;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserComputerResponse getUserWithComputers(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + userId));

        List<UserComputerResponse.ComputerDto> computers =
                computerClient.getComputersByUserId(userId);

        return new UserComputerResponse(user, computers);
    }
}