package com.collegemanagement.system.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Student")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	private String firstName;
	private String lastName;
	private String email;
	private Long contactNumber;
	private String gender;
	private String nationality;
	private String address;
	
	
	
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			joinColumns = {
				@JoinColumn(name="Student_id",referencedColumnName = "studentId")
			               },
		inverseJoinColumns = {
					@JoinColumn(name ="Course_id", referencedColumnName = "courseId")
		                      }
	  
	)
    private List<Course> course;
	 
	

}
