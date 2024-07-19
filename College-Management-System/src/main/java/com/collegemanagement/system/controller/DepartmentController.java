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

import com.collegemanagement.system.entity.DepartMent;
import com.collegemanagement.system.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/create")
	public DepartMent createdepartment(@RequestBody DepartMent departMent ) {
		return departmentService.createDepartMent(departMent);
		
	}
	
	@GetMapping("/all")
	public List<DepartMent> getAllDepartMent(){
		return departmentService.showAllDepartment();
	}
	//get department based on id 
	@GetMapping("/{departmentId}")
	public DepartMent getDepartmentById(@PathVariable Long departmentId) {
		return departmentService.getDepartmentbasedOnId(departmentId);
	}
	//delteDepartment
	
	@DeleteMapping("/{departmentId}")
	public String deleteDepartment(long departmentId) {
		return departmentService.deletedepartmentbyId(departmentId);
		
	}
	//update department
	@PutMapping("/update")
	public String updateDepartment(@RequestBody DepartMent departMent) {
		return departmentService.updatedepartmentbyId(departMent);
		
	}

}
