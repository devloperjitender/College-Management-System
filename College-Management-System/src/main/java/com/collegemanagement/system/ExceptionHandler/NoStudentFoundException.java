package com.collegemanagement.system.ExceptionHandler;

public class NoStudentFoundException extends RuntimeException {
	private String message;
	public NoStudentFoundException() {
		// TODO Auto-generated constructor stub
	}
	public NoStudentFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	

}
