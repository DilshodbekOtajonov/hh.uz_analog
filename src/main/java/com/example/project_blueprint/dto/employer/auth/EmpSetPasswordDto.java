package com.example.project_blueprint.dto.employer.auth;

import javax.validation.constraints.Pattern;

public record EmpSetPasswordDto(@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") String password) {
}
