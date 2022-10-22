package com.example.resume_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/21/2022 11:48 PM (Friday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityCreateDto {
    private String cityName;
    private String countryName;
}
