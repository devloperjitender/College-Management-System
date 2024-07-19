package com.collegemanagement.system.ExceptionHandler;

public class TeacherAlreadyAvailable extends RuntimeException {
    private String message;
	public TeacherAlreadyAvailable() {
		// TODO Auto-generated constructor stub
	}
	public TeacherAlreadyAvailable(String message) {
		super(message);
		this.message = message;
	}

}
