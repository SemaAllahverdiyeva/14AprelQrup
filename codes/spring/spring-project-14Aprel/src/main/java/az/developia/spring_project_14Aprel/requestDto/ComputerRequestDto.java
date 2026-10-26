package az.developia.spring_project_14Aprel.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
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

	@Schema(description = "Computer brand", example = "Dell")
	private String brand;

	@Schema(description = "Computer model", example = "XPS 13")
	private String model;

	@Schema(description = "Computer price", example = "1299.99")
	private Double price;
}