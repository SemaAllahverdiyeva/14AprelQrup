package com.practiceProject.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiceProject.demo.entity.Car;
import com.practiceProject.demo.repository.CarRepository;
import com.practiceProject.demo.requestDto.CarRequestDto;
import com.practiceProject.demo.responseDto.CarResponseDto;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<CarResponseDto> getCars(String model) {

		List<Car> cars;

		if (model == null || model.isBlank()) {
			cars = carRepository.findAll();
		} else {
			cars = carRepository.findByModelContaining(model);
		}

		List<CarResponseDto> result = new ArrayList<>();

		for (Car car : cars) {
			CarResponseDto dto = modelMapper.map(car, CarResponseDto.class);

			result.add(dto);
		}

		return result;
	}

	public Optional<Car> getCarById(int id) {
		return carRepository.findById(id);
	}

	public void addCar(CarRequestDto dto) {
		Car car = modelMapper.map(dto, Car.class);

		carRepository.save(car);
	}

	public void deleteCar(int id) {
		carRepository.deleteById(id);
	}

	public String updateCar(CarRequestDto dto) {

		if (dto.getId() == null || dto.getId() <= 0) {
			throw new IllegalArgumentException("id must not be null or less than zero");
		}

		Optional<Car> carById = carRepository.findById(dto.getId());

		if (carById.isPresent()) {
			Car car = modelMapper.map(dto, Car.class);

			carRepository.save(car);

		} else {
			throw new IllegalArgumentException("id not found");
		}

		return "Car updated successfully";
	}
}