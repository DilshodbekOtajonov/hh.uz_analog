package com.example.project_blueprint.exceptions;

public class OtpNotValidException extends RuntimeException{
    public OtpNotValidException(String message) {
        super(message);
    }
}
