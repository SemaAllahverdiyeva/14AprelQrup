package com.example.user_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user_service.response.UserComputerResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import lombok.Data;

@Service
public class ComputerClient {

    private final RestTemplate restTemplate;

    public ComputerClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retry(name = "computerService")
    @CircuitBreaker(
            name = "computerService",
            fallbackMethod = "fallback"
    )
    public List<UserComputerResponse.ComputerDto> getComputersByUserId(
            Long userId) {

        String url = "http://computer-service/computers/user/" + userId;

        ComputerListResponseDto response =
                restTemplate.getForObject(
                        url,
                        ComputerListResponseDto.class
                );

        if (response == null || response.getComputers() == null) {
            return List.of();
        }

        return response.getComputers();
    }

    public List<UserComputerResponse.ComputerDto> fallback(
            Long userId,
            Throwable exception) {

        System.out.println(
                "Computer service unavailable. Fallback activated!"
        );

        return List.of();
    }

    @Data
    public static class ComputerListResponseDto {

        private List<UserComputerResponse.ComputerDto> computers;
    }
}