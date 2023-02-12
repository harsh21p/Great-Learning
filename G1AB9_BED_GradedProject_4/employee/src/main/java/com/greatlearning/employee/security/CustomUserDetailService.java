package com.greatlearning.employee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.service.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByName(username);

        if(user == null)
            throw new UsernameNotFoundException("invalid userName");
        else return new CustomUserDetails(user);

    }
}