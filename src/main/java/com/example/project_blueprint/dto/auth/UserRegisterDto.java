package com.example.project_blueprint.dto.auth;

import javax.validation.constraints.Pattern;

public record UserRegisterDto(@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")String email, String firstName, String lastName) {
}
