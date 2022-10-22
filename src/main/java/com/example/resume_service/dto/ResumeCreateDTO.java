package com.example.resume_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/21/2022 3:34 PM (Friday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResumeCreateDTO {
    private String name;

    private String surname;

    private String phone;

    private String DateOfBirth;

    private String city;

    private String floor;

    private Set<String> citizenship;

    private String WorkExperience;

    private String speciality;

    private List<String> education;
    private Set<String> languageSkills;


}
