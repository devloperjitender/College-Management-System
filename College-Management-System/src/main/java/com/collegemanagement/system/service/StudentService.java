package com.collegemanagement.system.service;

import java.util.List;

import com.collegemanagement.system.Dto.StudentDto;
import com.collegemanagement.system.entity.Student;

import jakarta.validation.Valid;

public interface StudentService {
	
	public Student addStudent(StudentDto studentdto);
	public List<Student> getAllStudent();
	public Student getStudentById(Long studentId);
	public void deleteStudent(Long studentId);
	public String updateStudent(StudentDto studentdto );
	public String updateStudentRemoveCourse(StudentDto studentDto);
}
