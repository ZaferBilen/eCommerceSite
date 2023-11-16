package com.proje.eTicaretSitesi;

import java.util.HashMap;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.proje.eTicaretSitesi.core.utilities.exceptions.BusinessException;
import com.proje.eTicaretSitesi.core.utilities.exceptions.PasswordProblemDetails;
import com.proje.eTicaretSitesi.core.utilities.exceptions.ProblemDetails;

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
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails emailBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails passwordException(MethodArgumentNotValidException methodArgumentNotValidException ) {
		PasswordProblemDetails passwordProblemDetails = new PasswordProblemDetails();
		passwordProblemDetails.setMessage("VALIDATION.EXCEPTION");
		
		passwordProblemDetails.setPasswordErrors(new HashMap<String, String>());
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			passwordProblemDetails.getPasswordErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return passwordProblemDetails;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails getByIdException(NoSuchElementException noSuchElementException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(noSuchElementException.getMessage());
		
		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails getByIdDeleteException(MissingPathVariableException missingPathVariableException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(missingPathVariableException.getMessage());
		
		return problemDetails;
	}

}
