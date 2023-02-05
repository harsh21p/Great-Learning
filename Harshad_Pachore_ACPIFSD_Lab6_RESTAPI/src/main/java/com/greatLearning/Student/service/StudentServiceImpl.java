package com.greatLearning.Student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.Student.entity.Student;
import com.greatLearning.Student.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServices {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int theId) {
		return studentRepository.findById(theId).get();
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);

	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);

	}

}