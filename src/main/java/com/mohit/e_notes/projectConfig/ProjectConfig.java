package com.mohit.e_notes.projectConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ProjectConfig {

	@Bean
	public ModelMapper modelMapperBean()
	{
		return new ModelMapper();
	}
	
	@Bean
	public OpenAPI openApiConfig() {
	    return new OpenAPI()
	            .info(new Info()
	                    .title("E-Notes API")
	                    .description("REST API documentation for E-Notes application")
	                    .version("1.0.0")
	                    .contact(new Contact()
	                            .name("Mohit Bidwai")
	                            .email("mohit.19bidwai@gmail.com")));
	}
}
