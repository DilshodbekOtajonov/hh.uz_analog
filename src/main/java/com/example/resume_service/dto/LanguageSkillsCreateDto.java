package com.example.resume_service.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 5:22 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageSkillsCreateDto {
    @NotBlank(message = "Language can not be blank")
    private String language;

    @NotBlank(message = "can not be null")
    private String languageLevel;
}
