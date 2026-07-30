package com.practiceProject.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practiceProject.demo.entity.Car;
import com.practiceProject.demo.requestDto.CarRequestDto;

public interface CarRepository extends JpaRepository<Car, Integer> {
	
	List<Car> findByModelContaining(String model);

}