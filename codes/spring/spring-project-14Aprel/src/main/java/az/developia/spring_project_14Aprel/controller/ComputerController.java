package az.developia.spring_project_14Aprel.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

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

import az.developia.spring_project_14Aprel.entity.Computer;
import az.developia.spring_project_14Aprel.service.ComputerService;

@RestController
@RequestMapping(path = "/computers")
@CrossOrigin(origins = "*")
public class ComputerController {

	@Autowired
	private ComputerService computerService;

	@GetMapping("/getComputers")
	public List<Computer> getComputers(@RequestParam(required = false) String brand) {
		return computerService.getComputers(brand);
	}

	@GetMapping("/getComputer/{id}")
	public Optional<Computer> getComputer(@PathVariable int id) {
		return computerService.getComputerById(id);
	}

	@PostMapping("/addComputer")
	public String addComputer(@RequestBody Computer computer) {
		computerService.addComputer(computer);
		return "Computer added successfully";
	}

	@DeleteMapping("/deleteComputer/{id}")
	public String deleteComputer(@PathVariable int id) {
		computerService.deleteComputer(id);
		return "Computer deleted successfully";
	}

	@PutMapping(path = "/update")
	public String updateComputer(@RequestBody Computer computer) {
		return computerService.updateComputer(computer);
	}

	@GetMapping(path = "getComputerByBrand")
	public List<Computer> getComputerByBrand(@RequestParam(name = "brand") String brand) {
		return computerService.getComputers(brand);
	}
}