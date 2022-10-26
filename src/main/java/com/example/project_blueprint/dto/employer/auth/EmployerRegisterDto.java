package com.example.project_blueprint.dto.employer.auth;
import javax.validation.constraints.Pattern;

public record EmployerRegisterDto(@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") String email, String phoneNumber, String name,
                                  String surName, String companyName, String region) {
}
