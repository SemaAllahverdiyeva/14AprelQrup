package com.practiceProject.demo.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.practiceProject.demo.exception.ExceptionClass;

@RestControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler
	public String handle(ExceptionClass exc) {
		return exc.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
	}
}