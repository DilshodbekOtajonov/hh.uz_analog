package com.example.project_blueprint.exceptions;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 19:07 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(String message) {
        super(message);
    }
}
