package com.example.resume_service.service;

import com.example.resume_service.domains.ExperienceEntity;
import com.example.resume_service.domains.SkillEntity;
import com.example.resume_service.domains.WorkPlacesEntity;
import com.example.resume_service.dto.ExperienceCreateDTO;
import com.example.resume_service.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 2:25 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository repository;
    private final WorkPlacesService workPlacesService;
    private final SkillService skillService;

    public ExperienceEntity save(ExperienceCreateDTO dto) {
        List<WorkPlacesEntity> workPlacesEntityList = workPlacesService.save ( dto.getDTOs () );

        List<SkillEntity> save = skillService.save ( dto.getSkill ());

        ExperienceEntity experienceEntity=ExperienceEntity
                .builder ()
                .workPlaces ( workPlacesEntityList )
                .profile ( dto.getProfile () )
                .skill ( save )
                .build ();

        return experienceEntity ;
    }

    public List<ExperienceEntity> getAll() {
        return repository.findAll ();
    }
}
