package az.developia.spring_project_14Aprel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import az.developia.spring_project_14Aprel.entity.Computer;
import az.developia.spring_project_14Aprel.entity.User;
import az.developia.spring_project_14Aprel.repository.ComputerRepo;
import az.developia.spring_project_14Aprel.repository.UserRepository;
import az.developia.spring_project_14Aprel.requestDto.ComputerRequestDto;
import az.developia.spring_project_14Aprel.responseDto.ComputerResponseDto;

@Service
public class ComputerService {

	@Autowired
	private ComputerRepo computerRepo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ComputerResponseDto> getComputers(String brand) {

		List<Computer> computers;

		if (brand == null || brand.isBlank()) {
			computers = computerRepo.findAll();
		} else {
			computers = computerRepo.findByBrandContaining(brand);
		}

		List<ComputerResponseDto> result = new ArrayList<>();

		for (Computer computer : computers) {

			ComputerResponseDto dto = new ComputerResponseDto(
					computer.getId(),
					computer.getBrand(),
					computer.getModel());

			result.add(dto);
		}

		return result;
	}

	public ComputerResponseDto getComputerById(int id) {

		Computer computer = computerRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Computer not found"));

		return new ComputerResponseDto(
				computer.getId(),
				computer.getBrand(),
				computer.getModel());
	}

	public void addComputer(ComputerRequestDto dto) {

		String username = SecurityContextHolder.getContext()
				.getAuthentication()
				.getName();

		Optional<User> byUsername = userRepository.findByUsername(username);

		Integer userId = byUsername.get().getId();

		Computer computer = new Computer();

		computer.setBrand(dto.getBrand());
		computer.setModel(dto.getModel());
		computer.setPrice(dto.getPrice());

		computer.setUserId(userId);

		computerRepo.save(computer);
	}

	public void deleteComputer(int id) {
		computerRepo.deleteById(id);
	}

	public String updateComputer(ComputerRequestDto dto) {

		if (dto.getId() == null || dto.getId() <= 0) {
			throw new IllegalArgumentException("id must not be null or less than zero");
		}

		Optional<Computer> computerById = computerRepo.findById(dto.getId());

		if (computerById.isPresent()) {

			Computer computer = computerById.get();

			computer.setBrand(dto.getBrand());
			computer.setModel(dto.getModel());
			computer.setPrice(dto.getPrice());

			computerRepo.save(computer);

		} else {
			throw new IllegalArgumentException("id not found");
		}

		return "Computer updated successfully";
	}

	public List<ComputerResponseDto> getComputerByBrand(String brand) {

		List<Computer> computers = computerRepo.findByBrandContaining(brand);

		List<ComputerResponseDto> result = new ArrayList<>();

		for (Computer computer : computers) {

			result.add(new ComputerResponseDto(
					computer.getId(),
					computer.getBrand(),
					computer.getModel()));
		}

		return result;
	}

	public List<ComputerResponseDto> findComputersByPriceRange(Double a, Double b) {

		List<Computer> computers = computerRepo.findComputersByPriceRange(a, b);

		List<ComputerResponseDto> result = new ArrayList<>();

		for (Computer computer : computers) {

			result.add(new ComputerResponseDto(
					computer.getId(),
					computer.getBrand(),
					computer.getModel()));
		}

		return result;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public List<ComputerResponseDto> getComputersPagination(int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		Page<Computer> computers = computerRepo.findAll(pageable);

		List<ComputerResponseDto> result = new ArrayList<>();

		for (Computer computer : computers.getContent()) {

			ComputerResponseDto dto = new ComputerResponseDto(
					computer.getId(),
					computer.getBrand(),
					computer.getModel());

			result.add(dto);
		}

		return result;
	}
}