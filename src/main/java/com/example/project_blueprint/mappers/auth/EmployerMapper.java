package com.example.project_blueprint.mappers.auth;

import com.example.project_blueprint.domains.auth.Employer;
import com.example.project_blueprint.domains.auth.User;
import com.example.project_blueprint.dto.employer.EmployerDto;
import com.example.project_blueprint.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EmployerMapper {
    EmployerDto fromEmployer(Employer employer);
}
