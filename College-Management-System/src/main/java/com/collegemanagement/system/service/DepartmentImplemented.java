package com.collegemanagement.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagement.system.Dao.DepartmentDao;
import com.collegemanagement.system.ExceptionHandler.NoDepartMentAvailable;
import com.collegemanagement.system.entity.DepartMent;

@Service
public class DepartmentImplemented implements DepartmentService {
	
	@Autowired
	DepartmentDao departmentDao;

	@Override
	public DepartMent createDepartMent(DepartMent departMent) {
		
		return departmentDao.save(departMent);
	}

	@Override
	public List<DepartMent> showAllDepartment() {
		
		return departmentDao.findAll();
	}

	@Override
	public DepartMent getDepartmentbasedOnId(Long departmentId) {
		
		DepartMent departMentExist = departmentDao.findById(departmentId).orElse(null);
		if(departMentExist!=null) {
			 return departMentExist;
		}
		throw new NoDepartMentAvailable("No Department Available With id :"+departmentId);
	}

	@Override
	public String deletedepartmentbyId(long departmentId) {
		DepartMent departMentExist = departmentDao.findById(departmentId).orElse(null);
		if(departMentExist!=null) {
			departmentDao.deleteById(departmentId);
			return "Department Deleted Successfully with id :"+departmentId;
		}
		throw new NoDepartMentAvailable("No Department Available With id :"+departmentId);
	
		
	}

	@Override
	public String updatedepartmentbyId(DepartMent departMent) {
		    DepartMent departMent2 = departmentDao.findById(departMent.getDepartmentId()).orElse(null);
		    if(departMent2!=null) {
		       departmentDao.save(departMent);
		       return "DepartMent Update Successfully";
		    }
	throw new NoDepartMentAvailable("No DepartMent Available With id :"+departMent.getDepartmentId());
	}

	

}
