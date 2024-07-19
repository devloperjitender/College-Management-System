package com.collegemanagement.system.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemanagement.system.Dto.TeacherDto;
import com.collegemanagement.system.ExceptionHandler.NoDepartMentAvailable;
import com.collegemanagement.system.entity.Teacher;

import jakarta.validation.Valid;

public interface TeacherService {
	
	public String addTeacher(TeacherDto teacherDto);

	public List<Teacher> getAllTeacher();

	public Teacher getTeacherById(Long teacherId);

	public String deleteTeacher(Long teacherId);

	public String updateTeacher(TeacherDto teacherDto) ;

	public String removeCourse(Long teacherId, List<Long> courseId);

	

}
