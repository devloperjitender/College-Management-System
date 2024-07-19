package com.collegemanagement.system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagement.system.Dao.CourseDao;
import com.collegemanagement.system.Dao.StudentDao;
import com.collegemanagement.system.Dto.StudentDto;
import com.collegemanagement.system.ExceptionHandler.NoCourseAvailable;
import com.collegemanagement.system.ExceptionHandler.NoStudentFoundException;
import com.collegemanagement.system.entity.Course;
import com.collegemanagement.system.entity.Student;

@Service
public class StudentImplemented implements StudentService {
	@Autowired
	StudentDao studentDao;

	@Autowired
	CourseDao courseDao;

	@Override
	public Student addStudent(StudentDto studentdto) {
		List<Course> couList = new ArrayList<>();// 1
		
		for (Long courseId : studentdto.getCourseId()) {// 1,2,3
			Optional<Course> course = courseDao.findById(courseId);// 1
			if (course.isPresent()) {
				couList.add(course.get());	
			} else {
				
			throw new NoCourseAvailable("No Course Available with id :"+ courseId);

			}
		}
		Student student = Student.build(studentdto.getStudentId(), studentdto.getFirstName(),
				studentdto.getLastName(), studentdto.getEmail(), studentdto.getContactNumber(),
				studentdto.getGender(), studentdto.getNationality(), studentdto.getAddress(), couList);

		return studentDao.save(student);

	}

	@Override
	public List<Student> getAllStudent() {

		return studentDao.findAll();
	}

	@Override
	public Student getStudentById(Long studentId) {
		Student studentExisted = studentDao.findById(studentId).orElse(null);
		if (studentExisted != null)
			return studentExisted;
		throw new NoStudentFoundException("No Student Found with id :" + studentId);
	}

	@Override
	public void deleteStudent(Long studentId) {
		Student studentExisted = studentDao.findById(studentId).orElse(null);
		if (studentExisted != null) {
			studentExisted.getCourse().clear();
			studentDao.deleteById(studentId);
		}else {
		throw new NoStudentFoundException("No Student Found with id :" + studentId);
		}

	}

	@Override
	public String updateStudent(StudentDto studentdto) {
		
		Student existedStudent= studentDao.findById(studentdto.getStudentId()).orElse(null);
		if(existedStudent!=null) {
			for(Long courseid:studentdto.getCourseId()) {
				   Optional<Course> course = courseDao.findById(courseid);
				   if(course.isPresent()) {
				        if(!existedStudent.getCourse().contains(course.get())) {
					    existedStudent.getCourse().add(course.get());
				        }
				   }else {
					   throw new NoCourseAvailable("No Course is Present with id :"+courseid);
				   }
			}
			studentDao.save(existedStudent);
			return "Student Updated Successfully with id :"+studentdto.getStudentId();
		}else {
			throw new NoStudentFoundException("No Student Found With id :"+ studentdto.getStudentId());
		}
		

		 
	}

	@Override
	public String updateStudentRemoveCourse(StudentDto studentDto) {
	    // Find the student by ID
	    Student existedStudent = studentDao.findById(studentDto.getStudentId())
	                                       .orElseThrow(() -> new NoStudentFoundException("No Student Found With id: " + studentDto.getStudentId()));

	    // Iterate through each courseId in the DTO
	    for (Long courseId : studentDto.getCourseId()) {
	        // Find the course by courseId
	        Optional<Course> courseOptional = courseDao.findById(courseId);

	        if (courseOptional.isPresent()) {
	           existedStudent.getCourse().remove(courseOptional.get());

	        } else {
	            // If course is not found, throw an exception
	            throw new NoCourseAvailable("No Course is Present with id: " + courseId);
	        }
	    }

	    // Save the updated student (optional: depending on your cascade settings, this may not be necessary)
	     studentDao.save(existedStudent);

	    return "Student Updated Successfully with id: " + studentDto.getStudentId();
	}


}
