package com.example.resume_service.exceptions;

import lombok.Getter;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/26/22 12:16 PM (Friday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
@Getter
public class GenericNotFoundException extends RuntimeException{

    protected final Integer statusCode;
    public GenericNotFoundException(String message,Integer statusCode) {
        super(message);
        this.statusCode=statusCode;
    }


}
