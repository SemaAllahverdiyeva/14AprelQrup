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

import com.practiceProject.demo.entity.Car;
import com.practiceProject.demo.service.CarService;

@RestController
@RequestMapping(path = "/cars")
@CrossOrigin(origins = "*")
public class CarController {
	@Autowired
	private CarService carService;

	@GetMapping("/getCars")
	public List<Car> getCars(@RequestParam(required = false) String name) {
		return carService.getCars(name);
	}

	@GetMapping("/getCar/{id}")
	public Optional<Car> getCar(@PathVariable int id) {
		return carService.getCarById(id);
	}

	@PostMapping("/addCar")
	public String addCar(@RequestBody Car car) {
		carService.addCar(car);
		return "Car added successfully";
	}

	@DeleteMapping("/deleteCar/{id}")
	public String deleteCar(@PathVariable int id) {
		carService.deleteCar(id);
		return "Car deleted successfully";
	}

	@PutMapping(path = "/update")
	public String updateCar(@RequestBody Car car) {
		return carService.updateCar(car);
	}

	@GetMapping(path = "getCarByName")
	public List<Car> getCarByName(@RequestParam(name = "name") String name) {
		return carService.getCars(name);
	}
}
