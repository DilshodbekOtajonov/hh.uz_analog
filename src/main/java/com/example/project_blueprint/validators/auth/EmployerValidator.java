package com.example.project_blueprint.validators.auth;

import com.example.project_blueprint.domains.auth.Employer;
import com.example.project_blueprint.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployerValidator {

    private final EmployerRepository repository;

    public void validateKey(Long id) throws ValidationException {
        repository.findById(id).orElseThrow(() -> {
            throw new ValidationException("Not valid id!");
        });
    }

//    @Override
//    public void validOnCreate(EmployerCreateDto employerCreateDto) throws ValidationException {
//
//    }
//
//    @Override
//    public void validOnUpdate(EmployerUpdateDto cd) throws ValidationException {
//
//    }

    public void validateEmployer(Optional<Employer> employer) {
        if (employer.isEmpty()) {
            throw new ValidationException("EMPLOYER_NOT_FOUND");
        }
    }
}

