package az.developia.spring_project_14Aprel.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.spring_project_14Aprel.exception.ExceptionClass;
import az.developia.spring_project_14Aprel.exception.ResourcesNotFoundException;
import az.developia.spring_project_14Aprel.responseDto.ExceptionResponse;
import az.developia.spring_project_14Aprel.responseDto.ValidationResponse;

@RestControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handle(ExceptionClass exc) {

		List<ValidationResponse> validationResponses = new ArrayList<>();

		for (FieldError error : exc.getBindingResult().getFieldErrors()) {

			ValidationResponse validationResponse = new ValidationResponse(error.getField(), error.getDefaultMessage());

			validationResponses.add(validationResponse);
		}

		ExceptionResponse exceptionResponse = new ExceptionResponse("Validation error", validationResponses);

		return ResponseEntity.badRequest().body(exceptionResponse);
	}

	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<?> handle(ResourcesNotFoundException ex) {

		return ResponseEntity.status(404).body(ex.getMessage());
	}
}