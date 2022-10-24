package com.example.project_blueprint.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppError {

    private Timestamp timestamp;
    private Integer status;
    private String code;
    private String message;
    private String developerMessage;
    private String path;

    public AppError(String message, String developerMessage, WebRequest webRequest, HttpStatus httpStatus) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status = httpStatus.value();
        this.code = httpStatus.getReasonPhrase();
        this.message = message;
        this.developerMessage = developerMessage;
        this.path = ((ServletWebRequest) webRequest).getRequest().getRequestURI();
    }

    public AppError(String message, WebRequest webRequest, HttpStatus httpStatus) {
        this(message, message, webRequest, httpStatus);
    }
}