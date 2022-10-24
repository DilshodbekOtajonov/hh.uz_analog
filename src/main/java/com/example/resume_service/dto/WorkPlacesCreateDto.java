package com.example.resume_service.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 2:00 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkPlacesCreateDto {
    @NotBlank(message = "Start of work not be blank")
    @Pattern( regexp = "yyyy-MM-dd",message = "such a Date  is not satisfactory")

    private String startWork;

    private Boolean isEndWork;
    @Pattern ( regexp = "yyyy-MM-dd",message = "such a Date  is not satisfactory")

    private String endWork;
    @NotBlank(message = "Organization not be blank")
    private String organization;
    @NotBlank(message = "Position not be null")
    private String position;
    @NotBlank(message = "Job duties not be null")
    private String jobDuties;
}
