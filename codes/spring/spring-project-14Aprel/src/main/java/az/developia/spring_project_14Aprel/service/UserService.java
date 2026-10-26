package az.developia.spring_project_14Aprel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import az.developia.spring_project_14Aprel.entity.Authority;
import az.developia.spring_project_14Aprel.entity.User;
import az.developia.spring_project_14Aprel.exception.ResourcesNotFoundException;
import az.developia.spring_project_14Aprel.repository.AuthorityRepository;
import az.developia.spring_project_14Aprel.repository.UserRepository;
import az.developia.spring_project_14Aprel.requestDto.AuthRequestDto;
import az.developia.spring_project_14Aprel.requestDto.UserRequestDto;
import az.developia.spring_project_14Aprel.responseDto.UserResponseDto;
import az.developia.spring_project_14Aprel.util.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(AuthRequestDto dto) {

        Optional<User> user = userRepository.findByUsername(dto.getUsername());

        if (!user.isPresent() || !passwordEncoder.matches(dto.getPassword(), user.get().getPassword())) {
            throw new RuntimeException("Username or password incorrect!");
        }

        List<String> authorities = authorityRepository.findByUsername(user.get().getUsername())
                .stream()
                .map(Authority::getAuthority)
                .collect(Collectors.toList());

        return jwtUtil.generateToken(user.get().getUsername(), authorities);
    }

    public String addUser(UserRequestDto dto) {

        if (userRepository.existsByUsername(dto.getUsername())) {
            return "Username already exists!";
        }

        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setEnabled(true);

        userRepository.save(user);

        Authority authority = new Authority();
        authority.setUsername(dto.getUsername());
        authority.setAuthority("ROLE_USER");
        authorityRepository.save(authority);

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

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("User not found"));

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getUsername());
    }

    public String updateUser(UserRequestDto dto) {

        if (dto.getId() == null || dto.getId() <= 0) {
            throw new IllegalArgumentException("id must not be null or less than zero");
        }

        Optional<User> userById = userRepository.findById(dto.getId());

        if (userById.isPresent()) {

            User user = userById.get();

            user.setName(dto.getName());
            user.setSurname(dto.getSurname());
            user.setUsername(dto.getUsername());

            userRepository.save(user);

        } else {
            throw new IllegalArgumentException("id not found");
        }

        return "User updated successfully";
    }
}