package com.example.project_blueprint.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppErrorDto {
    private Timestamp timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;


    public AppErrorDto(HttpStatus status, String message) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
    }

    @Builder
    public AppErrorDto(HttpStatus status, String message, String path) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
        this.path = path;
    }

    public AppErrorDto(int scUnauthorized, String message) {
        this.status=scUnauthorized;
        this.message=message;
    }

}