package com.example.resume_service.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 2:52 PM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExperienceCreateDTO {

    private List<WorkPlacesCreateDto> DTOs;

    @NotBlank(message = "Profile not be blank")
    private String profile;

    private List<String> skill;

}
