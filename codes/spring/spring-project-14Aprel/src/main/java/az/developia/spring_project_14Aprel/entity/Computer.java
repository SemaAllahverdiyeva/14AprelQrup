package az.developia.spring_project_14Aprel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Computer {
	private int id;
	private String brand;
	private String model;
}