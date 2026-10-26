package com.example.computer_service.controller;

import com.example.computer_service.response.ComputerListResponse;
import com.example.computer_service.service.ComputerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping("/user/{userId}")
    public ComputerListResponse getComputersByUserId(
            @PathVariable Long userId) {

        return computerService.getComputersByUserId(userId);
    }
}