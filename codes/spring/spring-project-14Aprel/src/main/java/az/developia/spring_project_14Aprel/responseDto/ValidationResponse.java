package az.developia.spring_project_14Aprel.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationResponse {
	private String field;
	private String fieldMessage;
}
