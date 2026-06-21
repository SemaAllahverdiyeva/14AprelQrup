package com.practiceProject.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiceProject.demo.entity.Car;
import com.practiceProject.demo.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;

	public List<Car> getCars(String name) {

	    if (name == null || name.isBlank()) {
	        return carRepository.findAll();
	    }

	    return carRepository.findByNameContaining(name);
	}

	public Optional<Car> getCarById(int id) {
		return carRepository.findById(id);
	}

	public void addCar(Car car) {
		carRepository.save(car);
	}

	public void deleteCar(int id) {
		carRepository.deleteById(id);
	}

	public String updateCar(Car car) {
		if (car.getId() == null || car.getId() <= 0) {
			throw new IllegalArgumentException("id must not be null or less than zero");
		}

		Optional<Car> carById = carRepository.findById(car.getId());

		if (carById.isPresent()) {
			carRepository.save(car);

		} else {
			throw new IllegalArgumentException("id not found");
		}

		return "Car updated successfully";
	}

	public List<Car> getCarByBrand(String name) {
		return carRepository.findByNameContaining(name);
	}
}