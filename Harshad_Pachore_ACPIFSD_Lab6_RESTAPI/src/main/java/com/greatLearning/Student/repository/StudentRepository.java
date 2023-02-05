package com.greatLearning.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.Student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
