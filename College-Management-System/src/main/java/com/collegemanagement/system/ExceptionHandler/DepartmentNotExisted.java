package com.collegemanagement.system.ExceptionHandler;

public class DepartmentNotExisted extends RuntimeException {
	private String message;
	public DepartmentNotExisted() {
		// TODO Auto-generated constructor stub
	}
	public DepartmentNotExisted(String message) {
		super(message);
		this.message = message;
	}

	
	
}
