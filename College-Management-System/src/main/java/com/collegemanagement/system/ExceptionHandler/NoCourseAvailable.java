package com.collegemanagement.system.ExceptionHandler;

public class NoCourseAvailable extends RuntimeException{
	private String message;
	public NoCourseAvailable() {
		// TODO Auto-generated constructor stub
	}

	public NoCourseAvailable(String message) {
		super(message);
	}
	
}
