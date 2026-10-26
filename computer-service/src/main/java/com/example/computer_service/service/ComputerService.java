package com.example.computer_service.service;

import com.example.computer_service.repository.ComputerRepository;
import com.example.computer_service.response.ComputerListResponse;
import org.springframework.stereotype.Service;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public ComputerListResponse getComputersByUserId(Long userId) {
        return new ComputerListResponse(
                computerRepository.findAllByUserId(userId)
        );
    }
}