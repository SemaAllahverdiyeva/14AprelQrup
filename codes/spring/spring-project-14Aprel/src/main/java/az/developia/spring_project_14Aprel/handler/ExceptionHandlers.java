package az.developia.spring_project_14Aprel.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.spring_project_14Aprel.exception.ExceptionClass;
import az.developia.spring_project_14Aprel.exception.ResourcesNotFoundException;

@RestControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler
	public String handle(ExceptionClass exc) {
		return exc.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
	}

	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<?> handle(ResourcesNotFoundException ex) {
		return ResponseEntity.status(404).body(ex.getMessage());
	}
}