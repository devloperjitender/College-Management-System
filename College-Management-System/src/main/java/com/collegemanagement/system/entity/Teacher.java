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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Teacher")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacherId;
	private String teacherFirstName;
	private String teacherLastName;
	private String teacherEmail;
	private long  teacherContactNumber;
	private String teacherGender;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Teacher_department")
	private DepartMent department;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Teacher_course",
	 joinColumns = {@JoinColumn(name="teacher_id",referencedColumnName = "teacherId")},
	 inverseJoinColumns = {@JoinColumn(name="Course_d",referencedColumnName = "courseId")}
	)
	private List<Course> courses;
	
	


}
