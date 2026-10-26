package com.example.userservice.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.response.UserComputerResponse;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository,
                       RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserComputerResponse getUserWithComputers(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + userId));

        String url = "http://localhost:8081/computers/user/" + userId;

        ResponseEntity<ComputerListResponseDto> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        ComputerListResponseDto.class
                );

        List<UserComputerResponse.ComputerDto> computers =
                response.getBody() == null
                        ? List.of()
                        : response.getBody().getComputers();

        return new UserComputerResponse(user, computers);
    }

    @lombok.Data
    public static class ComputerListResponseDto {
        private List<UserComputerResponse.ComputerDto> computers;
    }
}