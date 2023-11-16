package com.proje.eTicaretSitesi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@EnableWebSecurity 
@SpringBootApplication
@RestControllerAdvice
public class ETicaretSitesiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ETicaretSitesiApplication.class, args);
	}
	@Bean   
	public ModelMapper getModelMapper() {
	return new ModelMapper();
	}

}
