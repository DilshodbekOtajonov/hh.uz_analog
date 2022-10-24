package com.example.project_blueprint.dto.auth;

import javax.validation.constraints.Pattern;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 12:14 PM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */


public record UserRegisterWithOtpDto(@Pattern(regexp = "^[A-Z\\d._%+-]+@[A-Z\\d.-]+\\\\.[A-Z]{2,6}$") String email) {
}
