package com.example.resume_service.dto.resume;

import com.example.resume_service.dto.country.CountryDTO;
import com.example.resume_service.dto.experience.ExperienceDTO;
import com.example.resume_service.dto.language.LanguageSkillDto;
import lombok.*;

import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/24/2022 5:56 PM (Monday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumeDTO {
    private Long userId;

    private Long id;

    private String name;

    private String surname;


    private String phone;

    private String city;


    private String dateOfBirth;

    private String floor;


    private List<CountryDTO> citizenship;

    private Boolean workExperience;


    private String career;


    private Integer salary;


    private String currencyType;

    private ExperienceDTO education;

    private String level;

    private List<LanguageSkillDto> languageSkills;
}
