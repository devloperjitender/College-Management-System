package com.collegemanagement.system.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String , String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		Map<String, String> errorMap= new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(NoStudentFoundException.class)
	public Map<String, String> handleNoStudentFoundException(NoStudentFoundException exception){
		 Map<String, String> errorMap= new HashMap<>();
		 errorMap.put("errorMessage", exception.getLocalizedMessage());
		return errorMap;
		
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(NoCourseAvailable.class)
	public Map<String,String> handleNoCourseAvailable(NoCourseAvailable exception){
		Map<String,String> errorMap= new HashMap<>();
		errorMap.put("errorMessage", exception.getLocalizedMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(TeacherAlreadyAvailable.class)
	public Map<String,String> handleTeacherAlreadyAvailable(TeacherAlreadyAvailable exception){
		Map<String,String> errorMap= new HashMap<>();
		errorMap.put("errorMessage", exception.getLocalizedMessage());
		return errorMap;
	}
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DepartmentNotExisted.class)
	public Map<String,String> handleDepartmentNotExisted(DepartmentNotExisted exception){
		Map<String,String> errorMap= new HashMap<>();
		errorMap.put("errorMessage", exception.getLocalizedMessage());
		return errorMap;
	}
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(NoTeacherAvailable.class)
	public Map<String,String> handleNoTeacherAvailable(NoTeacherAvailable exception){
		Map<String,String> errorMap= new HashMap<>();
		errorMap.put("errorMessage", exception.getLocalizedMessage());
		return errorMap;
	}
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(NoDepartMentAvailable.class)
	public Map<String,String> handleNoDepartMentAvailable(NoDepartMentAvailable exception){
		Map<String,String> errorMap= new HashMap<>();
		errorMap.put("errorMessage", exception.getLocalizedMessage());
		return errorMap;
	}
	

}
