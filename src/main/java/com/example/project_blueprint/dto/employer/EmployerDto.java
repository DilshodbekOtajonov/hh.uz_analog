package com.example.project_blueprint.dto.employer;

import com.example.project_blueprint.dto.GenericDto;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployerDto extends GenericDto {
    private Long id;
}
