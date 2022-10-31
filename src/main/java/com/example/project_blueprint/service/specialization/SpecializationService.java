package com.example.project_blueprint.service.specialization;

import com.example.project_blueprint.domains.specialization.Specialization;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:53 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Service
public interface SpecializationService {
    Specialization getSpecializationById(Long id);
}
