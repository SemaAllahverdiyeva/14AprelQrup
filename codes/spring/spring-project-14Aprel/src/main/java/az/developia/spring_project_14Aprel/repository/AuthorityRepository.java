package az.developia.spring_project_14Aprel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.spring_project_14Aprel.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    List<Authority> findByUsername(String username);
}