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
public class ComputerResponseDto implements Serializable{
	private Integer id;
	private String brand;
	private String model;
}
