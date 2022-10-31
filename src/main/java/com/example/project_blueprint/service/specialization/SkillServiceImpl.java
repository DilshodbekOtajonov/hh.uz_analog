package com.example.project_blueprint.service.specialization;

import com.example.project_blueprint.domains.specialization.Skill;
import com.example.project_blueprint.exceptions.SkillNotFoundException;
import com.example.project_blueprint.repository.specialization.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:55 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@RequiredArgsConstructor
@Service
public class SkillServiceImpl implements SkillService{
    private final SkillRepository skillRepository;

    @Override
    public Skill getSkillById(Long id) {
        Skill skillNotFoundById = skillRepository.findById(id).orElseThrow(() -> {
            throw new SkillNotFoundException("Skill Not Found By Id");
        });
        return skillNotFoundById;
    }
}
