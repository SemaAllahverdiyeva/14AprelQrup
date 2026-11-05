package com.example.computer_service.service;

import com.example.computer_service.entity.Computer;
import com.example.computer_service.event.ComputerCreatedEvent;
import com.example.computer_service.repository.ComputerRepository;
import com.example.computer_service.response.ComputerListResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public ComputerService(
            ComputerRepository computerRepository,
            RabbitTemplate rabbitTemplate,
            ObjectMapper objectMapper) {

        this.computerRepository = computerRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public ComputerListResponse getComputersByUserId(Long userId) {

        return new ComputerListResponse(
                computerRepository.findAllByUserId(userId)
        );
    }

    public Computer createComputer(Computer computer) {

        Computer savedComputer = computerRepository.save(computer);

        ComputerCreatedEvent event = new ComputerCreatedEvent(
                savedComputer.getId(),
                savedComputer.getName(),
                savedComputer.getBrand(),
                savedComputer.getPrice(),
                savedComputer.getUserId()
        );

        try {

            String eventJson = objectMapper.writeValueAsString(event);

            rabbitTemplate.convertAndSend(
                    "computer.exchange",
                    "computer.created",
                    eventJson
            );

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Event JSON error", e);
        }

        return savedComputer;
    }
}