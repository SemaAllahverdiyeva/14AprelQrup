package az.developia.spring_project_14Aprel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.spring_project_14Aprel.entity.User;
import az.developia.spring_project_14Aprel.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public String addUser(User user) {

		if (userRepository.existsByUsername(user.getUsername())) {
			return "Username already exists!";
		}

		userRepository.save(user);
		return "User added successfully";
	}
}
