package com.collegemanagement.system.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
public @interface ValidateContactNumber {
	public String message() default "Invalid Contact Number";
	
	Class<?>[] groups() default {}; // Ensure this line is present
    Class<? extends Payload>[] payload() default {};
	

}
