package com.greatlearning.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.model.ErrorResponse;
import com.greatlearning.employee.responseHandler.HttpStatusCode;
import com.greatlearning.employee.service.RoleService;
import com.greatlearning.employee.service.UserService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("/user")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user) {
        user = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PatchMapping("/user/{id}/role")
    public ResponseEntity<User> update(@RequestBody Role role, @PathVariable("id") int id) {
        User updatedUser = userService.updateUser(role, id);
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(updatedUser);
    }

    @PostMapping("/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        role = roleService.saveRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> genericExceptionHandler(Exception exc) throws ParseException {
        ErrorResponse response = new ErrorResponse(400, exc.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, new HttpStatusCode(400).getHttpStatus());
    }
}
