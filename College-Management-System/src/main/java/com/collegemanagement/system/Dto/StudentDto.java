package com.collegemanagement.system.Dto;

import java.util.List;

import com.collegemanagement.system.entity.Course;
import com.collegemanagement.system.validation.ValidateContactNumber;
import com.collegemanagement.system.validation.ValidateGender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentDto {
	

	private Long studentId;
	@NotBlank(message = "Please Enter the Valid name ")
	private String firstName;
	@NotBlank(message = "Please Enter the Valid name ")
	private String lastName;
	@Email(message = "Please Enter the valid Email")
	private String email;
	@ValidateContactNumber
	private Long contactNumber;
	//Custom Annotation
	@ValidateGender(message="Invalid Gender : Gender Should Be Male or Female")
	private String gender;
	@NotNull(message = "Nationality Should Not be Null")
	private String nationality;
	@NotNull(message = "adress Should not Be Null")
	private String address;
	
	private List<Long> courseId;
	
	
}
