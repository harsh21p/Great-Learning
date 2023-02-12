package com.greatlearning.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.exception.RoleNotFoundException;
import com.greatlearning.employee.exception.UserNotFoundException;
import com.greatlearning.employee.exception.UserRoleAlreadyExistException;
import com.greatlearning.employee.repository.UserRepo;

import java.util.List;
import java.util.ListIterator;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        List<Role> roles = user.getRoles();
        ListIterator<Role> itr = roles.listIterator();
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        while(itr.hasNext()){
            Role tempRole = itr.next();
            Role role = tempRole;
            if(tempRole.getId() == 0){
                tempRole = roleService.findByName(role.getName());
                if(tempRole == null) tempRole = roleService.saveRole(role);
            }
            itr.set(tempRole);
        }
        return userRepo.save(user);
    }

    @Override
    public User findUserByName(String username) {
        return userRepo.findUserByName(username);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(Role role, int id) {

        role = roleService.findByName(role.getName());
        if(role == null) throw new RoleNotFoundException("invalid Role");

        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("invalid User with id: "+ id));
        List<Role> roles = user.getRoles();
        if(roles.contains(role)) throw new UserRoleAlreadyExistException("user already has the Role: " + role.getName());
        user.addRole(role);

        return userRepo.save(user);
    }
}
