package com.example.user_service.response;

import java.util.List;

import com.example.user_service.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserComputerResponse {

	private User user;
	private List<ComputerDto> computers;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class ComputerDto {

		private Long id;
		private String name;
		private String brand;
		private Double price;
		private Long userId;
	}
}