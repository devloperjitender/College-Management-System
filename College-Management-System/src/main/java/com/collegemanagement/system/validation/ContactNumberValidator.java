package com.collegemanagement.system.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ValidateContactNumber, Long> {

	@Override
	public boolean isValid(Long contactNumber, ConstraintValidatorContext context) {
		if(contactNumber==null) {
		return false;
		}
		String contact = String.valueOf(contactNumber);
		
		
		return contact.length()==10;
				
	}

}
