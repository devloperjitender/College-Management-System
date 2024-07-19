package com.collegemanagement.system.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegemanagement.system.entity.Course;
@Repository
public interface CourseDao  extends  JpaRepository<Course, Long>{

	

	
}
