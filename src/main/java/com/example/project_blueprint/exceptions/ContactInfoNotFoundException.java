package com.example.project_blueprint.exceptions;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 17:09 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
public class ContactInfoNotFoundException extends RuntimeException{
    public ContactInfoNotFoundException(String message) {
        super(message);
    }
}
