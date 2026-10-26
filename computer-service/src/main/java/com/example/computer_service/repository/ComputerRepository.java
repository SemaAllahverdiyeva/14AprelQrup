package com.example.computer_service.repository;

import com.example.computer_service.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

    List<Computer> findAllByUserId(Long userId);
}

