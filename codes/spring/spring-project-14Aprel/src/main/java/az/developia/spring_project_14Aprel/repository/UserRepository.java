package az.developia.spring_project_14Aprel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.spring_project_14Aprel.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByUsername(String username);
}
