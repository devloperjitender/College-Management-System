package com.collegemanagement.system.service;

import java.util.List;

import com.collegemanagement.system.entity.Course;

public interface CourseService {
	

	public Course createCourse(Course course);
	public List<Course> getAllCourse();
	public Course getCourseById(Long courseId);
	public String updateCourse(Long courseId,Course course);
	public String deleteCourse(Long courseId);

}
