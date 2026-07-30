package az.developia.spring_project_14Aprel.controller;

import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import az.developia.spring_project_14Aprel.requestDto.ComputerRequestDto;
import az.developia.spring_project_14Aprel.responseDto.ComputerResponseDto;
import az.developia.spring_project_14Aprel.service.ComputerService;

@RestController
@RequestMapping(path = "/computers")
@CrossOrigin(origins = "*")
public class ComputerController {

	@Autowired
	private ComputerService computerService;

	@GetMapping("/getComputers")
	public List<ComputerResponseDto> getComputers(@RequestParam(required = false) String brand) {
		return computerService.getComputers(brand);
	}

	@GetMapping(value = "/getComputer/{id}", produces = { "application/json", "application/xml" })
	@Cacheable(value = "computer")
	public ComputerResponseDto getComputer(@PathVariable int id) {
		return computerService.getComputerById(id);
	}

	@PostMapping("/addComputer")
	public String addComputer(@RequestBody ComputerRequestDto dto) {
		computerService.addComputer(dto);
		return "Computer added successfully";
	}

	@DeleteMapping("/deleteComputer/{id}")
	public String deleteComputer(@PathVariable int id) {
		computerService.deleteComputer(id);
		return "Computer deleted successfully";
	}

	@PutMapping("/update")
	public String updateComputer(@RequestBody ComputerRequestDto dto) {
		return computerService.updateComputer(dto);
	}

	@GetMapping("/getComputerByBrand")
	public List<ComputerResponseDto> getComputerByBrand(@RequestParam String brand) {
		return computerService.getComputerByBrand(brand);
	}

	@GetMapping("/price-range")
	public List<ComputerResponseDto> getComputersByPriceRange(@RequestParam Double a, @RequestParam Double b) {
		return computerService.findComputersByPriceRange(a, b);
	}

	@GetMapping("/pagination")
	public List<ComputerResponseDto> getComputersPagination(@RequestParam int page, @RequestParam int size) {

		return computerService.getComputersPagination(page, size);
	}
}