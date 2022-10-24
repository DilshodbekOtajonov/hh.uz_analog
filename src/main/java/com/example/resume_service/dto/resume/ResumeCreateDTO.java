package com.example.resume_service.dto.resume;

import com.example.resume_service.dto.ExperienceCreateDTO;
import com.example.resume_service.dto.LanguageSkillsCreateDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/21/2022 3:34 PM (Friday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumeCreateDTO {
    @NotBlank(message = "name can not be blank")
    private String name;

    @NotBlank(message = "surname can not be blank")
    private String surname;

    @NotBlank(message = "phone can not be blank")
    @Pattern (regexp = "^(\\\\+\\\\d{1,3}( )?)?((\\\\(\\\\d{1,3}\\\\))|\\\\d{1,3})[- .]?\\\\d{3,4}[- .]?\\\\d{4}$",message = "such a phone number is not satisfactory ")
    private String phone;
    @NotBlank(message = "city can not be blank")
    private String city;

    @NotBlank(message = "Date Of Birth can not be blank")
    @Pattern ( regexp = "yyyy-MM-dd",message = "such a Date  is not satisfactory")
    private String dateOfBirth;
    @NotBlank(message = "Floor can not be blank")
    private String floor;

    @NotBlank(message = "Citizenship can not be blank")
    private List<String> citizenship;

    private Boolean workExperience;

    @NotBlank(message = "Career can not be blank")
    private String career;

    @NotBlank(message = "Salary can not be blank")
    private Integer salary;


    @NotBlank(message = "Currency Type can not be blank")
    private String currencyType;

    private ExperienceCreateDTO education;


    @NotBlank(message = "Level can not be blank")
    private String level;

//    @NotBlank(message = "Language can not be blank")
    private List<LanguageSkillsCreateDto> languageSkills;


}
