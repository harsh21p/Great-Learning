package com.greatlearning.employee.service;

import java.util.List;

import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.entity.User;

public interface UserService {
    User saveUser(User user) ;
    User findUserByName(String username);
    List<User> getAll();
    User updateUser(Role role, int id);
}
