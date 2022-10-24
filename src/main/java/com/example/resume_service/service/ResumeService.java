package com.example.resume_service.service;

import com.example.resume_service.domains.CountryEntity;
import com.example.resume_service.domains.ExperienceEntity;
import com.example.resume_service.domains.LanguageSkillsEntity;
import com.example.resume_service.domains.ResumeEntity;
import com.example.resume_service.dto.resume.ResumeCreateDTO;
import com.example.resume_service.dto.resume.ResumeDTO;
import com.example.resume_service.enums.CurrencyType;
import com.example.resume_service.enums.Floor;
import com.example.resume_service.enums.Level;
import com.example.resume_service.mapper.ResumeMapper;
import com.example.resume_service.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 6:32 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class ResumeService {

    private final CityService cityService;
    private final ResumeMapper mapper;
    private final CountryService countryService;

    private final ExperienceService experienceService;
    private final ResumeRepository repository;

    private final LanguageSkillsService languageService;

    public ResumeEntity save(ResumeCreateDTO dto) {

        ExperienceEntity experienceEntity = experienceService.save ( dto.getEducation () );
        String cityEntity = cityService.checkCity ( dto.getCity () );
        List<CountryEntity> countryEntityList = countryService.checkCityList ( dto.getCitizenship () );
        List<LanguageSkillsEntity> languageSkillsEntityList = languageService.save ( dto.getLanguageSkills () );
        ResumeEntity resume = ResumeEntity.builder ()
                .createdAt ( Timestamp.valueOf ( LocalDateTime.now ( Clock.systemDefaultZone () ) ) )
                .name ( dto.getName () )
                .surname ( dto.getSurname () )
                .phone ( dto.getPhone () )
                .city ( cityEntity )
                .dateOfBirth ( LocalDate.parse ( dto.getDateOfBirth (), DateTimeFormatter.ISO_LOCAL_DATE ) )
                .floor ( Floor.findByName ( dto.getFloor () ) )
                .citizenship ( countryEntityList )
                .workExperience ( dto.getWorkExperience () )
                .career ( dto.getCareer () )
                .salary ( dto.getSalary () )
                .currencyType ( CurrencyType.findByName ( dto.getCurrencyType () ) )
                .education ( experienceEntity )
                .level ( Level.findByName ( dto.getLevel () ) )
                .languageSkills ( languageSkillsEntityList )
                .build ();

        return repository.save ( resume );
    }

    public List<ResumeDTO> getAll() {

        return mapper.toDTOList ( repository.findAll() );
    }
}
