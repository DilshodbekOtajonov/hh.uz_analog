package com.example.resume_service.service;

import com.example.resume_service.domains.SkillEntity;
import com.example.resume_service.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 3:07 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository repository;


    public List<SkillEntity> save(List<String> skill) {
        List<SkillEntity> skillEntityList = new ArrayList<> ();
        for (String s : skill) {
            if (Objects.nonNull ( s )) {
                skillEntityList.add (  ( SkillEntity.builder ()
                        .skillName ( s )
                        .build () ) );
            }
        }
        return skillEntityList;
    }
}
