package com.example.resume_service.service;

import com.example.resume_service.domains.LanguageEntity;
import com.example.resume_service.domains.LanguageSkillsEntity;
import com.example.resume_service.dto.LanguageSkillsCreateDto;
import com.example.resume_service.enums.LanguageLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 7:15 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class LanguageSkillsService {


    private final LanguageService service;

    public List<LanguageSkillsEntity> save(List<LanguageSkillsCreateDto> dto) {


        List<LanguageSkillsEntity> entityList = new ArrayList<> ();

        for (LanguageSkillsCreateDto languageSkill : dto) {
            LanguageEntity language = service.checkLanguageName ( languageSkill );
            if (Objects.nonNull ( language )) {
                entityList.add ( (LanguageSkillsEntity.builder ()
                        .language ( languageSkill.getLanguage () )
                        .languageLevel ( LanguageLevel.findByName ( languageSkill.getLanguageLevel () ) )
                        .build ()) );
            }
        }

            return entityList;


    }
}
