package com.vh1ne.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vh1ne.dto.SignUpRequest;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, SignUpRequest> {

	@Override
	public boolean isValid(final SignUpRequest user, final ConstraintValidatorContext context) {
		return user.getPassword().equals(user.getMatchingPassword());
	}

}
