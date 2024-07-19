package com.collegemanagement.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.collegemanagement.system.Dto.StudentDto;
import com.collegemanagement.system.entity.Student;
import com.collegemanagement.system.service.StudentImplemented;
import com.collegemanagement.system.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody @Valid StudentDto studentDto) {
		return studentService.addStudent(studentDto);
		
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
		
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudentById(@PathVariable Long studentId) {
		return studentService.getStudentById(studentId);
		
	}
	
	@DeleteMapping("/student/{studentId}")
	public String deleteStudentbasedOnId(@PathVariable Long studentId) {
		studentService.deleteStudent(studentId);
		return "Student delete with id :"+studentId;
	}
	
	@PutMapping("/update/addCourse")
	public String updateStudentAddCourse( @RequestBody @Valid StudentDto studentDto) {
		return studentService.updateStudent( studentDto);
		
	}

	@PutMapping("/update/deleteCourse")
	public String updateStudentDeleteCourse( @RequestBody @Valid StudentDto studentDto) {
		return studentService.updateStudentRemoveCourse( studentDto);
		
	}
	
	
	
	

}
