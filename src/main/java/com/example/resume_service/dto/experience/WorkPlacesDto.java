package com.example.resume_service.dto.experience;

import lombok.*;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/24/2022 6:28 PM (Monday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkPlacesDto {
    private String startWork;


    private String endWork;

    private String organization;

    private String position;

    private String jobDuties;
}
