package az.developia.spring_project_14Aprel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.spring_project_14Aprel.entity.User;
import az.developia.spring_project_14Aprel.exception.ResourcesNotFoundException;
import az.developia.spring_project_14Aprel.repository.UserRepository;
import az.developia.spring_project_14Aprel.requestDto.UserRequestDto;
import az.developia.spring_project_14Aprel.responseDto.UserResponseDto;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public String addUser(UserRequestDto dto) {

		if (userRepository.existsByUsername(dto.getUsername())) {
			return "Username already exists!";
		}

		User user = new User();

		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());

		userRepository.save(user);

		return "User added successfully";
	}

	public Integer countAllUsers() {
		return userRepository.countAllUsers();
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	public void deleteUser(Integer id) {
		if (id == null || id <= 0) {
			throw new RuntimeException("id must not be null or less than 0");
		}

		Optional<User> byId = userRepository.findById(id);

		if (byId.isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new RuntimeException("id not found");
		}
	}

	public UserResponseDto getUserById(int id) {

		User user = userRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("User not found"));

		return new UserResponseDto(user.getId(), user.getName(), user.getUsername());
	}
}
