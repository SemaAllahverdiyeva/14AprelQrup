package az.developia.spring_project_14Aprel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI customOpenAPI() {

		return new OpenAPI().info(new Info().title("Computer Shopping API").version("3.1.0")
				.description("REST API documentation for Computer Shopping project"));
	}
}