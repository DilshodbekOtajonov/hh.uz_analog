package com.example.resume_service.dto.language;

import lombok.*;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/24/2022 6:40 PM (Monday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LanguageSkillDto {
    private String language;

    private String languageLevel;
}
