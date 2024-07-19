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

import com.collegemanagement.system.entity.Course;
import com.collegemanagement.system.service.CourseService;

@RestController()
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	@PostMapping("/create")
	public Course createCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
		
	}
	
	//getCourseById
	@GetMapping("get/{courseId}")
	public Course  getCourseById(@PathVariable Long courseId) {
		return courseService.getCourseById(courseId);
	
	}
	//getAllCourse
	@GetMapping("/all")
	public List<Course> getAllCourse(){
		return courseService.getAllCourse();
	}
	
	//update course
	@PutMapping("update/{courseId}")
	public String updateCourse(@PathVariable Long courseId,@RequestBody Course course) {
		return courseService.updateCourse(courseId, course);
		
	}
	
	
	//delete course
	@DeleteMapping("delete/{courseId}")
	public String deleteCourse(@PathVariable Long courseId) {
		return courseService.deleteCourse(courseId);
		
	}
	  
}
