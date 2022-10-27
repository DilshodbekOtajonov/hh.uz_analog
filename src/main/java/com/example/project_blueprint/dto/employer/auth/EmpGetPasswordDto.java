package com.example.project_blueprint.dto.employer.auth;

import javax.validation.constraints.Pattern;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 12:14 PM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */


public record EmpGetPasswordDto(@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") String email) {
}
