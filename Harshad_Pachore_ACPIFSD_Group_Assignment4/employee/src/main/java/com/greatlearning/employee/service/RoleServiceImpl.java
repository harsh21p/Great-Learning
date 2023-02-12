package com.greatlearning.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.exception.DuplicateRoleException;
import com.greatlearning.employee.repository.RoleRepo;


@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepo roleRepo;
    @Override
    public Role saveRole(Role role) {
        if(roleRepo.findByName(role.getName()) != null) throw new DuplicateRoleException("Role already exist");
        return roleRepo.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepo.findByName(name);
    }
}
