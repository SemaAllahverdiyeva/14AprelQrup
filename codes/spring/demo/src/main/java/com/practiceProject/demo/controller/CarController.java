package com.practiceProject.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.practiceProject.demo.entity.Car;
import com.practiceProject.demo.requestDto.CarRequestDto;
import com.practiceProject.demo.responseDto.CarResponseDto;
import com.practiceProject.demo.service.CarService;

import org.springframework.validation.BindingResult;
import com.practiceProject.demo.exception.ExceptionClass;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "*")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/getCars")
	public List<CarResponseDto> getCars(@RequestParam(required = false) String model) {
		return carService.getCars(model);
	}

	@GetMapping("/getCar/{id}")
	public Optional<Car> getCar(@PathVariable int id) {
		return carService.getCarById(id);
	}

	@PostMapping("/addCar")
	public String addCar(@Valid @RequestBody CarRequestDto dto,
			BindingResult br) {

		if (br.hasErrors()) {
			throw new ExceptionClass(br);
		}

		carService.addCar(dto);

		return "Car added successfully";
	}

	@DeleteMapping("/deleteCar/{id}")
	public String deleteCar(@PathVariable int id) {
		carService.deleteCar(id);

		return "Car deleted successfully";
	}

	@PutMapping("/update")
	public String updateCar(@Valid @RequestBody CarRequestDto dto) {

		return carService.updateCar(dto);
	}

	@GetMapping("/getCarByName")
	public List<CarResponseDto> getCarByName(@RequestParam String model) {

		return carService.getCars(model);
	}
}