package az.developia.spring_project_14aprel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import az.developia.spring_project_14aprel.entity.Computer;
import az.developia.spring_project_14aprel.entity.Employee;
import az.developia.spring_project_14aprel.entity.RAM;

@Configuration
public class MyConfing {

	@Bean
	public Computer myComputer() {

		Computer c = new Computer();

		c.setId(1);
		c.setBrand("Acer");
		c.setPrice(1000);
		c.setColor("Gray");
		c.setRam(new RAM());

		return c;
	}
	
    public RAM ram() {
        RAM r = new RAM();
        r.setSize(16);
        r.setType("type");
        
        return r;
    }
    
    @Bean
    public Employee employee(Computer computer) {
        Employee e = new Employee();
        e.setComputer(computer);

        return e;
    }
}