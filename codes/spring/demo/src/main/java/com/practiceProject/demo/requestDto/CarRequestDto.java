package com.practiceProject.demo.requestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestDto {

	private Integer id;

	@NotBlank(message = "Marka cannot be empty")
	private String marka;

	@NotBlank(message = "Model cannot be empty")
	private String model;

	@NotNull(message = "Year cannot be null")
	@Min(value = 2000, message = "Year must be greater than or equal to 2000")
	private Integer year;

}