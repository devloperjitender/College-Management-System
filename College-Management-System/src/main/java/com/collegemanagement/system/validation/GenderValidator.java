package com.collegemanagement.system.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<ValidateGender, String> {

	@Override
	public boolean isValid(String gender, ConstraintValidatorContext context) {
		List<String> list= Arrays.asList("Male","Female");
		if(list.contains(gender)) {
			return true;
		}
		return false;
		
		
	}

	
}
