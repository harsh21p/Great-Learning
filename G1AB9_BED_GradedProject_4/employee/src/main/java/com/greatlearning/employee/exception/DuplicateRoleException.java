package com.greatlearning.employee.exception;

public class DuplicateRoleException extends RuntimeException{

    public DuplicateRoleException(String message){
        super(message);
    }
}
