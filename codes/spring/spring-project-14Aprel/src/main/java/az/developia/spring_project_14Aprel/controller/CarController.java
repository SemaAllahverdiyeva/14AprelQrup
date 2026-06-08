package az.developia.spring_project_14Aprel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.spring_project_14Aprel.entity.Car;

@RestController
public class CarController {

	@GetMapping(path = "/getCars")
	public List<Car> getCars(){
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car(1, "a", "a1"));
		cars.add(new Car(2, "b", "b1"));
		cars.add(new Car(3, "c", "c1"));
		return cars;
	}

}