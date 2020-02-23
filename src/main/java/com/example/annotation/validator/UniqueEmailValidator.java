package com.example.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.annotation.annotation.UniqueEmail;
import com.example.repository.UserRepository;



@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UniqueEmail constraintAnnotation) {

	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (email == null) {
			return false;
		}

		if (userRepository.findUserByEmail(email) != null) {
			return false;
		} else {
			return true;
		}

	}

}
