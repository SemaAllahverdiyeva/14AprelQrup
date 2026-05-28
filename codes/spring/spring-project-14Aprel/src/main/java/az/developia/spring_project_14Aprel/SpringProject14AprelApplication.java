package az.developia.spring_project_14Aprel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import az.developia.spring_project_14Aprel.config.AppProperties;

@SpringBootApplication
public class SpringProject14AprelApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(SpringProject14AprelApplication.class, args);

		AppProperties bean = run.getBean(AppProperties.class);
		bean.showProperties();
	}

}
