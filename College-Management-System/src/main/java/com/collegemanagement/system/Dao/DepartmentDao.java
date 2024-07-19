package com.collegemanagement.system.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemanagement.system.entity.DepartMent;

public interface DepartmentDao extends JpaRepository<DepartMent, Long> {

}
