package com.java.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.java.model.User;

public class UserValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if(user.getName() == null || user.getName().length() == 0 || user.getName().length() < 6) {
			errors.rejectValue("name", "field.required"); //name la property cua model User
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "field.required");
		if(user.getPassword().length() < 6 || user.getPassword().length() >12) {
			errors.rejectValue("password", "password.invalid");
		}
	}

}
