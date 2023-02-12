package com.greatlearning.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employee.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findUserByName(String name);
}