package az.developia.spring_project_14Aprel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import az.developia.spring_project_14Aprel.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByUsername(String username);

//    @Query(value = "SELECT COUNT(*) FROM users", nativeQuery = true)
//    Integer countAllUsers();

	@Query("SELECT COUNT(u) FROM User u")
	Integer countAllUsers();

	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findUserByEmail(@Param("email") String email);

	boolean existsByEmail(String email);
}
