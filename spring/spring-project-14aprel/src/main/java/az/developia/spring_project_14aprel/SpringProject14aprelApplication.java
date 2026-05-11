package az.developia.spring_project_14aprel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import az.developia.spring_project_14aprel.entity.Computer;
import az.developia.spring_project_14aprel.entity.Employee;

@SpringBootApplication
public class SpringProject14aprelApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringProject14aprelApplication.class, args);

		Computer computer = context.getBean(Computer.class);

		System.out.println(computer.getId());
		System.out.println(computer.getBrand());
		System.out.println(computer.getPrice());
		System.out.println(computer.getColor());
		System.out.println(computer.getRam());

		Employee employee = context.getBean(Employee.class);

		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getAge());
		System.out.println(employee.getSalary());
		System.out.println(employee.getComputer());
	}
}