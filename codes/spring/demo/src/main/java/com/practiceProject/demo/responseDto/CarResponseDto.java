package com.practiceProject.demo.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarResponseDto {
	private Integer id;
	private String marka;
	private String model;
}
