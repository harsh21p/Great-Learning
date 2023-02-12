package com.greatlearning.employee.service;

import com.greatlearning.employee.entity.Role;

public interface RoleService {
    Role saveRole(Role role);

    Role findByName(String name);
}
