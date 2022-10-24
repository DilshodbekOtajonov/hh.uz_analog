package com.example.resume_service.handler;

import com.example.resume_service.exceptions.GenericNotFoundException;
import com.example.resume_service.response.ApiErrorResponse;
import com.example.resume_service.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericNotFoundException.class)
    public ApiResponse<ApiErrorResponse> handle404(GenericNotFoundException e, HttpServletRequest request) {
        return new ApiResponse<> ( ApiErrorResponse.builder ()
                .friendlyMessage ( e.getMessage () )
                .developerMessage ( Arrays.toString ( e.getStackTrace () ) )
                .requestPath ( request.getRequestURL ().toString () )
                .build (),
                HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<ApiErrorResponse> globalHandler(Exception e, HttpServletRequest request) {
        return new ApiResponse<> ( ApiErrorResponse.builder ()
                .friendlyMessage ( e.getMessage () )
                .developerMessage ( Arrays.toString ( e.getStackTrace () ) )
                .requestPath ( request.getRequestURL ().toString () )
                .build (),
                HttpStatus.BAD_REQUEST );
    }


}
