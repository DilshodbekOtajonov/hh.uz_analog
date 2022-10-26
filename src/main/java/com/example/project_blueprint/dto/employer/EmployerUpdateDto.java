package com.example.project_blueprint.dto.employer;


import com.example.project_blueprint.dto.GenericDto;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployerUpdateDto extends GenericDto {
    private Long id;
    private String email;
    private String phoneNumber;
    private String name;
    private String password;
    private String surName;
    private String companyName;
    private String region;
}
