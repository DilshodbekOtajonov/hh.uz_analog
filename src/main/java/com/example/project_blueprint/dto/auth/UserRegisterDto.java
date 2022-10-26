package com.example.project_blueprint.dto.auth;

import com.example.project_blueprint.dto.jwt.JWTToken;

public record UserRegisterDto(String email, String firstName, String lastName) {
}
