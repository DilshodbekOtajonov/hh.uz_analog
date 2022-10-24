package com.example.resume_service.service;

import com.example.resume_service.domains.LanguageEntity;
import com.example.resume_service.dto.LanguageSkillsCreateDto;
import com.example.resume_service.dto.language.LanguageCreateDTO;
import com.example.resume_service.exceptions.GenericNotFoundException;
import com.example.resume_service.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 7:04 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository repository;

    public Integer save(LanguageCreateDTO dto) {
        LanguageEntity language = LanguageEntity.builder ()
                .languageName ( dto.getLanguageName () )
                .build ();
        LanguageEntity save = repository.save ( language );
        return save.getId ();
    }


    public List<LanguageEntity> getAll() {
        return repository.findAll ();
    }


    public LanguageEntity checkLanguageName(LanguageSkillsCreateDto dto) {
        return repository.checkLanguageName ( dto.getLanguage () )
                .orElseThrow ( () -> new GenericNotFoundException (
                        "Language  not found by name : %s".formatted ( dto.getLanguage () )
                 ,404));


    }


}
