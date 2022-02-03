package com.pruebatecnica.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // Habilitar Swagger2
public class SwaggerConfig {
	// Configurar la instancia de bean de Swagger's Docket
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.pruebatecnica.demo.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Demo Prueba Tecnica Service API",
				"Demo Prueba Tecnica API Description",
				"1.0",
				"https://www.apache.org/licenses/LICENSE-2.0",
				new Contact("alecea", "https://espanol.yahoo.com/?p=us", "apis@demo.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
}
