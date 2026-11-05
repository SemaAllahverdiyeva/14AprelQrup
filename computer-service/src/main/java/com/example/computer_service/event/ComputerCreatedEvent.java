package com.example.computer_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerCreatedEvent {

    private Long id;
    private String name;
    private String brand;
    private Double price;
    private Long userId;
}