package com.example.project_blueprint.exceptions;

/**
 * @author "Tojaliyev Asliddin"
 * @since 25/10/22 23:15 (Tuesday)
 * hh.uz_analog/IntelliJ IDEA
 */
public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
