package com.example.resume_service.dto.country;

import lombok.*;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/21/2022 11:48 PM (Friday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityCreateDto {
    private String cityName;
    private String countryName;
}
