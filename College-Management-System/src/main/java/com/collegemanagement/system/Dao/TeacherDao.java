package com.collegemanagement.system.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemanagement.system.entity.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Long>{

}
