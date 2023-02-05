package com.greatLearning.Student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_Name")
	private String firstName;

	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "Course")
	private String course;
   
	@Column(name = "Country")
	private String country;

	public Student() {
	}

	public Student(String firstName, String lastName, String course, String country) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.country = country;
	}
}
