package com.example.resume_service.dto.workPlaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/22/2022 2:00 AM (Saturday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkPlacesCreateDto {
    private String startWork;
    private Boolean isEndWork;
    private String endWork;
    private String organization;
    private String position;
    private String jobDuties;
}
