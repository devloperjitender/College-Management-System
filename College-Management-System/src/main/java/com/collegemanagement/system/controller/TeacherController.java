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

import com.collegemanagement.system.Dto.TeacherDto;
import com.collegemanagement.system.ExceptionHandler.NoDepartMentAvailable;
import com.collegemanagement.system.entity.Teacher;
import com.collegemanagement.system.service.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	@PostMapping("/add")
	public String addTeacher(@RequestBody @Valid  TeacherDto teacherDto) {
		return teacherService.addTeacher(teacherDto);
	}
	
	//View All Teacher
	
	@GetMapping("/getAll")
	public List<Teacher> getAllTeacher(){
		return teacherService.getAllTeacher();
	}
	
	
	//View Teacher by TeacherID
	@GetMapping("/{teacherId}")
	public Teacher getTeacherById(@PathVariable Long teacherId) {
		return teacherService.getTeacherById(teacherId);
		
	}
	//Delete Teacher
	@DeleteMapping("/{teacherId}")
	public String deleteTeacher(@PathVariable Long teacherId) {
		return teacherService.deleteTeacher(teacherId);
	}
	
	//update Teacher
	
	@PutMapping("/update")
	public String AddTeacherToMultipleCourse( @RequestBody @Valid TeacherDto teacherDto)  {
		return teacherService.updateTeacher(teacherDto);
	}
	
	@PutMapping("/removeCourse/{teacherId}")
	public String removeCourseFromTeacher(@PathVariable Long teacherId, @RequestBody List<Long> courseId ) {
		return teacherService.removeCourse(teacherId,courseId);
	}
	
	

}
