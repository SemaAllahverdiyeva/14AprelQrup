package com.practiceProject.demo.exception;

import org.springframework.validation.BindingResult;

public class ExceptionClass extends RuntimeException {
	private BindingResult bindingResult;

	public ExceptionClass(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}
}