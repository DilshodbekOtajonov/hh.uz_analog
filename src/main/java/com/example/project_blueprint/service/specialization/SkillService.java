package com.example.project_blueprint.service.specialization;

import com.example.project_blueprint.domains.specialization.Skill;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:54 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Service
public interface SkillService {
    Skill getSkillById(Long id);
}
