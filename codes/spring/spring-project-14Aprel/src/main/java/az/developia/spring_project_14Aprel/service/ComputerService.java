package az.developia.spring_project_14Aprel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.spring_project_14Aprel.entity.Computer;
import az.developia.spring_project_14Aprel.repository.ComputerRepository;

@Service
public class ComputerService {

	@Autowired
	private ComputerRepository computerRepository;

	public List<Computer> getComputers(String brand) {
		return computerRepository.getComputers(brand);
	}

	public Optional<Computer> getComputerById(int id) {
		return computerRepository.getComputerById(id);
	}

	public void addComputer(Computer computer) {
		computerRepository.addComputer(computer);
	}

	public void deleteComputer(int id) {
		computerRepository.deleteComputer(id);
	}

	public String updateComputer(Computer computer) {
		if(computer.getId() == null || computer.getId() <= 0) {
			throw new IllegalArgumentException("id must not be or lest and zero");
		}
		
		Optional<Computer> computerById = computerRepository.getComputerById(computer.getId());
		if (computerById.isPresent()) {
			computerRepository.update(computer);
		} else {
			throw new IllegalArgumentException("id not found");
		}
		return "Computer updated succesfully";
	}
}