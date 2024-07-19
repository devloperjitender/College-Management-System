package com.collegemanagement.system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagement.system.Dao.CourseDao;
import com.collegemanagement.system.Dao.DepartmentDao;
import com.collegemanagement.system.Dao.TeacherDao;
import com.collegemanagement.system.Dto.TeacherDto;
import com.collegemanagement.system.ExceptionHandler.DepartmentNotExisted;
import com.collegemanagement.system.ExceptionHandler.NoCourseAvailable;
import com.collegemanagement.system.ExceptionHandler.NoDepartMentAvailable;
import com.collegemanagement.system.ExceptionHandler.NoTeacherAvailable;
import com.collegemanagement.system.ExceptionHandler.TeacherAlreadyAvailable;
import com.collegemanagement.system.entity.Course;
import com.collegemanagement.system.entity.DepartMent;
import com.collegemanagement.system.entity.Teacher;

import jakarta.transaction.Transactional;

@Service
public class TeacherImplemented implements TeacherService {

	@Autowired
	TeacherDao teacherDao;
	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	CourseDao courseDao;
	@Autowired
	DepartmentDao depatmentDao;

	@Override
	public String addTeacher(TeacherDto teacherDto) {

		List<Course> list = new ArrayList<>();

		DepartMent departMentexisted = departmentDao.findById(teacherDto.getDepartmentId()).orElse(null);
		if (departMentexisted != null) {
			for (Long courseId : teacherDto.getCoursesId()) {
				Optional<Course> course = courseDao.findById(courseId);
				if (course.isPresent()) {
					list.add(course.get());
				} else
					throw new NoCourseAvailable("No Course Available with id :" + courseId);
			}
			Teacher teacher = Teacher.build(teacherDto.getTeacherId(), teacherDto.getTeacherFirstName(), teacherDto.getTeacherLastName(), teacherDto.getTeacherEmail(), teacherDto.getTeacherContactNumber(), teacherDto.getTeacherGender(), departMentexisted, list);
			teacherDao.save(teacher);
			return "Teacher Added with id :" + teacher.getTeacherId();
		}
		throw new DepartmentNotExisted("With this Id = :" + teacherDto.getDepartmentId() + "No DepartMent Available ");

	}

	@Override
	public List<Teacher> getAllTeacher() {

		return teacherDao.findAll();
	}

	@Override
	public Teacher getTeacherById(Long teacherId) {

		Teacher teacherExisted = teacherDao.findById(teacherId).orElse(null);
		if (teacherExisted != null) {
			return teacherExisted;
		}
		throw new NoTeacherAvailable("No Teacher Available With Id :" + teacherId);
	}

	@Override
	public String deleteTeacher(Long teacherId) {
		Teacher teacherExist = teacherDao.findById(teacherId).orElse(null);
		if (teacherExist != null) {
			teacherExist.getCourses().clear();
			teacherDao.deleteById(teacherId);
			return "Teacher Deleted With Id :" + teacherId;
		}
		throw new NoTeacherAvailable("No Teacher Available With Id :" + teacherId);
	}

	@Override
	public String updateTeacher(TeacherDto teacherDto) {
		Teacher teacherExist = teacherDao.findById(teacherDto.getTeacherId()).orElseThrow(()-> new NoTeacherAvailable("Teacher Not Available With id :"+teacherDto.getTeacherId()));
		
		if (teacherExist != null) {
		   DepartMent departMentExist = departmentDao.findById(teacherDto.getDepartmentId()).orElse(null);
		   if(departMentExist!=null) {
			   for(Long courseId:teacherDto.getCoursesId()) {
				   Optional<Course> course = courseDao.findById(courseId);
				   if(course.isPresent() && !teacherExist.getCourses().contains(course.get())) {
					   teacherExist.getCourses().add(course.get());

				   }
			   }
			   teacherExist.setDepartment(departMentExist);

			   teacherDao.save(teacherExist);
			   
		   }else {
			   throw new NoDepartMentAvailable("No Department Available with id :"+teacherDto.getDepartmentId()); 
		   }
		}
		return "Teacher Update Successfully";
			
		
		}

	@Override
	public String removeCourse(Long teacherId, List<Long> courseId) {
		Teacher teacherExist = teacherDao.findById(teacherId).orElseThrow(()-> new NoTeacherAvailable("Teacher Not Available With id :"+teacherId));
		if (teacherExist != null) {
			  
	    for(Long coursidExist:courseId) {
					   Optional<Course> course = courseDao.findById(coursidExist);
					   if(course.isPresent()) {
						   teacherExist.getCourses().remove(course.get());

					   }
	 }
		teacherDao.save(teacherExist);
		
	  }
		return "Teacher Course Removed Successfully";
	}













}



