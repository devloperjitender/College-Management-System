package com.collegemanagement.system.service;

import java.util.List;

import com.collegemanagement.system.entity.DepartMent;

public interface DepartmentService {
	public DepartMent createDepartMent(DepartMent departMent);

	public List<DepartMent> showAllDepartment();

	public DepartMent getDepartmentbasedOnId(Long departmentId);

	public String deletedepartmentbyId(long departmentId);

	public String updatedepartmentbyId(DepartMent departMent);

}
