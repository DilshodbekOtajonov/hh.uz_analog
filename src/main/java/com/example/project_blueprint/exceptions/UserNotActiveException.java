package com.example.project_blueprint.exceptions;

public class UserNotActiveException  extends RuntimeException{
    public UserNotActiveException(String message) {
        super(message);
    }
}
