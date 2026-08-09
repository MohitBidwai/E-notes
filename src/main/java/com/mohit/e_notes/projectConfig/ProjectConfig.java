package com.mohit.e_notes.projectConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

	@Bean
	public ModelMapper modelMapperBean()
	{
		return new ModelMapper();
	}
	
}
