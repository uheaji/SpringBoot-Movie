package com.cos.movie.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;

@RestController
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value=IllegalArgumentException.class)
	public CommonDto<String> 요청잘못(IllegalArgumentException e) {
		return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
}
