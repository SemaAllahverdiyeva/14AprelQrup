package az.developia.spring_project_14Aprel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import az.developia.spring_project_14Aprel.requestDto.ComputerRequestDto;
import az.developia.spring_project_14Aprel.responseDto.ComputerResponseDto;
import az.developia.spring_project_14Aprel.service.ComputerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/computers")
@CrossOrigin(origins = "*")
@Tag(name = "Computer", description = "Computer management APIs")
public class ComputerController {

	@Autowired
	private ComputerService computerService;

	@GetMapping("/getComputers")
	@Operation(summary = "Get all computers", description = "Returns all computers or filters them by brand")
	public List<ComputerResponseDto> getComputers(

			@Parameter(description = "Computer brand", example = "Dell") @RequestParam(required = false) String brand) {

		return computerService.getComputers(brand);
	}

	@GetMapping(value = "/getComputer/{id}", produces = { "application/json", "application/xml" })
	@Cacheable(value = "computer")
	@Operation(summary = "Get a computer by ID", description = "Returns a computer by its ID")
	public ComputerResponseDto getComputer(

			@Parameter(description = "Computer ID", example = "1") @PathVariable int id) {

		return computerService.getComputerById(id);
	}

	@PostMapping("/addComputer")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@Operation(summary = "Add a new computer", description = "Creates and saves a new computer")
	public String addComputer(@RequestBody ComputerRequestDto dto) {

		computerService.addComputer(dto);

		return "Computer added successfully";
	}

	@DeleteMapping("/deleteComputer/{id}")
	@Operation(summary = "Delete a computer", description = "Deletes a computer by its ID")
	public String deleteComputer(

			@Parameter(description = "Computer ID", example = "1") @PathVariable int id) {

		computerService.deleteComputer(id);

		return "Computer deleted successfully";
	}

	@PutMapping("/update")
	@Operation(summary = "Update a computer", description = "Updates an existing computer")
	public String updateComputer(@RequestBody ComputerRequestDto dto) {

		return computerService.updateComputer(dto);
	}

	@GetMapping("/getComputerByBrand")
	@Operation(summary = "Get computers by brand", description = "Returns computers that match the specified brand")
	public List<ComputerResponseDto> getComputerByBrand(

			@Parameter(description = "Computer brand", example = "HP") @RequestParam String brand) {

		return computerService.getComputerByBrand(brand);
	}

	@GetMapping("/price-range")
	@Operation(summary = "Get computers by price range", description = "Returns computers with prices between the specified minimum and maximum values")
	public List<ComputerResponseDto> getComputersByPriceRange(

			@Parameter(description = "Minimum price", example = "500.0") @RequestParam Double a,

			@Parameter(description = "Maximum price", example = "2000.0") @RequestParam Double b) {

		return computerService.findComputersByPriceRange(a, b);
	}

	@GetMapping("/pagination")
	@Operation(summary = "Get computers with pagination", description = "Returns a paginated list of computers based on the specified page number and page size")
	public List<ComputerResponseDto> getComputersPagination(

			@Parameter(description = "Page number. Starts from 0", example = "0") @RequestParam int page,

			@Parameter(description = "Number of computers per page", example = "10", required = true) @RequestParam int size) {

		return computerService.getComputersPagination(page, size);
	}
}