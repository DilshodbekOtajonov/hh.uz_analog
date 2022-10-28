package com.example.project_blueprint.dto.employer;


import com.example.project_blueprint.domains.auth.Employer;
import com.example.project_blueprint.dto.GenericDto;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployerDto extends GenericDto {
    private String email;
    private String companyName;

    private Employer.EmployerStatus status;
    private String password;
}
