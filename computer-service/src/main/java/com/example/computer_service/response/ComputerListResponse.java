package com.example.computer_service.response;

import com.example.computer_service.entity.Computer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerListResponse {
	private List<Computer> computers;
}