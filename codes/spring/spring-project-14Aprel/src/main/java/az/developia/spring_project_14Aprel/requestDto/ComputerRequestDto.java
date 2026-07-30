package az.developia.spring_project_14Aprel.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComputerRequestDto {
	private Integer id;
	private String brand;
	private String model;
	private Double price;
}
