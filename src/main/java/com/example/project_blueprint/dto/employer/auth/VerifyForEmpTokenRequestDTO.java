package com.example.project_blueprint.dto.employer.auth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VerifyForEmpTokenRequestDTO {

    @NotNull
    private String email;

    @NotNull
    private String otp;

}
