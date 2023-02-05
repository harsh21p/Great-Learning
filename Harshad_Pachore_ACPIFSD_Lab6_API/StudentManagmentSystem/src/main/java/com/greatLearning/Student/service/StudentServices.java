package com.greatLearning.Student.service;

import java.util.List;

import com.greatLearning.Student.entity.Student;

public interface StudentServices {
	
	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student theBook);

	public void deleteById(int theId);

}
