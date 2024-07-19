package com.collegemanagement.system.Dto;

import java.util.List;

import com.collegemanagement.system.entity.Course;
import com.collegemanagement.system.entity.DepartMent;
import com.collegemanagement.system.validation.ValidateContactNumber;
import com.collegemanagement.system.validation.ValidateGender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class TeacherDto {
	
	private Long teacherId;
	@NotBlank(message = "First name Should Not be Empty or null")
	private String teacherFirstName;
	@NotBlank(message = "First name Should Not be Empty or null")
	private String teacherLastName;
	@Email
	private String teacherEmail;
	@NotNull
	@ValidateContactNumber(message = "Invalid Mobile Number ")
	private long  teacherContactNumber;
	@ValidateGender(message="Gender Should be Male Or Female ")
	private String teacherGender;
	private Long departmentId;
	private List<Long> coursesId;
	

}
