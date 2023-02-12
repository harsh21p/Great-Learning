package com.greatlearning.employee.exception;

public class UserRoleAlreadyExistException extends RuntimeException{

    public UserRoleAlreadyExistException(String message){
        super(message);
    }
}
