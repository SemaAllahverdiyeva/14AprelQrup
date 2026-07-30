package az.developia.spring_project_14Aprel.requestDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		if (value.trim().isEmpty()) {
			return false;
		}

		if (!value.contains("@") && !value.contains(".")) {
			return false;
		}

		return true;
	}
}