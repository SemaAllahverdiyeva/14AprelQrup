package az.developia.spring_project_14Aprel.responseDto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto implements Serializable{
	private Integer id;
	private String name;
	private String username;
}
