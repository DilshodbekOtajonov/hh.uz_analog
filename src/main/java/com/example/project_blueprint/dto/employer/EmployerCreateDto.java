package com.example.project_blueprint.dto.employer;

import com.example.project_blueprint.dto.Dto;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployerCreateDto implements Dto {
    @NotBlank(message = "Name can not be blank")
    private String name;

    @NotBlank(message = "Surname can not be blank")
    private String surName;

    @NotBlank(message = "email can not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            message = "Email is invalid")
    private String email;

    @NotBlank(message = "Phone number can not be blank")
    private String phoneNumber;

    @NotBlank(message = "Company name can not be blank")
    private String companyName;

    @NotBlank(message = "Region can not be blank")
    private String region;
}
