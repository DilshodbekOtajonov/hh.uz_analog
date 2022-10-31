package com.example.project_blueprint.service.specialization;

import com.example.project_blueprint.domains.specialization.Specialization;
import com.example.project_blueprint.exceptions.SpecializationNotFoundException;
import com.example.project_blueprint.repository.specialization.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:53 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@RequiredArgsConstructor
@Service
public class SpecializationServiceImpl implements SpecializationService{
    private final SpecializationRepository specializationRepository;

    @Override
    public Specialization getSpecializationById(Long id) {
        Specialization specializationNotFoundById = specializationRepository.findById(id).orElseThrow(() -> {
            throw new SpecializationNotFoundException("Specialization Not Found By Id");
        });
        return specializationNotFoundById;
    }
}
