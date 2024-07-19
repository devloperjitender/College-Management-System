package com.collegemanagement.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagement.system.Dao.CourseDao;
import com.collegemanagement.system.ExceptionHandler.NoCourseAvailable;
import com.collegemanagement.system.entity.Course;

@Service
public  class CourseImplemented implements CourseService {
	
	@Autowired
	CourseDao courseDao;

	@Override
	public Course createCourse(Course course) {
		
		return courseDao.save(course);
	}

	@Override
	public List<Course> getAllCourse() {
		
		return courseDao.findAll();
	}

	@Override
	public Course getCourseById(Long courseId) {
		
		Course CourseExist=courseDao.findById(courseId).orElse(null);
		if(CourseExist!=null) {
			return CourseExist;
		}
		throw new NoCourseAvailable("No Course Available With Id :"+courseId);
	}

	@Override
	public String updateCourse(Long courseId,Course course) {
		Course courseExisted= courseDao.findById(courseId).orElse(null);
		if(courseExisted!=null) {
			courseDao.save(course);
			return "course updated with Courseid :"+courseId;
		}
		throw new NoCourseAvailable("No Course Available with id :"+courseId);
		
	}

	@Override
	public String deleteCourse(Long courseId) {
		Course courseExisted= courseDao.findById(courseId).orElse(null);
		if(courseExisted!=null) {
			courseDao.deleteById(courseId);
			return "course deleted with Courseid :"+courseId;
		}
		throw new NoCourseAvailable("No Course Available with id :"+courseId);
		
	}

	
	
}
