package com.core.service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition
@Configuration
public class OpenApi30Config {
	

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Documentación de servicios").version("1.0.0").description("Spring doc"));
	}
}