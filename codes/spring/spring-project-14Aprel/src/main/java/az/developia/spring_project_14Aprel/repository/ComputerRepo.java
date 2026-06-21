package az.developia.spring_project_14Aprel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.spring_project_14Aprel.entity.Computer;

public interface ComputerRepo extends JpaRepository<Computer, Integer> {
	List<Computer> findBybrandContanting(String name);
}