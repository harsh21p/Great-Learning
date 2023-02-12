package com.greatlearning.employee.exception;

public class RoleNotFoundException extends RuntimeException{

    public RoleNotFoundException(String message){
        super(message);
    }
}
