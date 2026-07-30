package az.developia.spring_project_14Aprel.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
	private Integer id;

	@NotBlank(message = "Name cannot be empty")
	@Size(min = 3, max = 15)
	private String name;

	@NotBlank(message = "Surname cannot be empty")
	@Size(min = 5, max = 20)
	private String surname;

	@NotBlank(message = "Username cannot be empty")
	@Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
	private String username;

	@NotBlank(message = "Password cannot be empty")
	@Size(min = 4, message = "Password must be at least 6 characters")
	private String password;

	@ValidEmail
	@UniqueEmail
	private String email;
}