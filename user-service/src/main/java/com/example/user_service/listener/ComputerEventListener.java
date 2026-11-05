package com.example.user_service.listener;

import com.example.user_service.event.ComputerCreatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ComputerEventListener {

    private final ObjectMapper objectMapper;

    public ComputerEventListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "computer.created.queue")
    public void handleComputerCreated(String eventJson) {

        try {

            ComputerCreatedEvent event =
                    objectMapper.readValue(
                            eventJson,
                            ComputerCreatedEvent.class
                    );

            System.out.println("New computer event received!");
            System.out.println("Computer ID: " + event.getId());
            System.out.println("Computer name: " + event.getName());
            System.out.println("User ID: " + event.getUserId());

        } catch (Exception e) {
            throw new RuntimeException("Event processing failed", e);
        }
    }
}