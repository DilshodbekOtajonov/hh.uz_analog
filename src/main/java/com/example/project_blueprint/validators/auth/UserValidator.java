package com.example.project_blueprint.validators.auth;

import com.example.project_blueprint.domains.auth.User;
import com.example.project_blueprint.repository.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository repository;

    public void validateKey(Long id) throws ValidationException {
        repository.findById(id).orElseThrow(() -> {
            throw new ValidationException("Not valid id!");
        });
    }

//    @Override
//    public void validOnCreate(UserCreateDto userCreateDto) throws ValidationException {
//
//    }
//
//    @Override
//    public void validOnUpdate(UserUpdateDto cd) throws ValidationException {
//
//    }

    public void validateUser(Optional<User> user) {
        if (user.isEmpty()) {
            throw new ValidationException("USER_NOT_FOUND");
        }
    }
}