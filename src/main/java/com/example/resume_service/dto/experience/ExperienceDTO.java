package com.example.resume_service.dto.experience;

import com.example.resume_service.dto.SkillCreateDTO;
import lombok.*;

import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/24/2022 6:26 PM (Monday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExperienceDTO {
    private List<WorkPlacesDto> workPlaces;


    private String profile;

    private List<SkillCreateDTO> skill;
}
