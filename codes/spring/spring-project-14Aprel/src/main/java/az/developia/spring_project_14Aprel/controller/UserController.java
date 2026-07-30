package az.developia.spring_project_14Aprel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.spring_project_14Aprel.entity.User;
import az.developia.spring_project_14Aprel.requestDto.UserRequestDto;
import az.developia.spring_project_14Aprel.responseDto.UserResponseDto;
import az.developia.spring_project_14Aprel.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public String addUser(@Valid @RequestBody UserRequestDto dto, BindingResult br) {

		if (br.hasErrors()) {
			throw new az.developia.spring_project_14Aprel.exception.ExceptionClass(br);
		}

		userService.addUser(dto);

		return "User added successfully";
	}

	@GetMapping("/countUsers")
	public Integer countUsers() {
		return userService.countAllUsers();
	}

	@GetMapping("/getUserByEmail")
	public User getUserByEmail(@RequestParam String email) {
		return userService.findUserByEmail(email);
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return "User deleted successfully";
	}
	
	@GetMapping("/getUser/{id}")
	public UserResponseDto getUser(@PathVariable Integer id) {
	    return userService.getUserById(id);
	}
}
