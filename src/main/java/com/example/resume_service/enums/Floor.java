package com.example.resume_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 6:50 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@AllArgsConstructor
public enum Floor {

    MALE("Male"),FEMALE("Female");

    public String key;
    public static Floor findByName(String floor) {
        return Arrays.stream(Floor.values())
                .filter(floor1 -> floor1.name().equalsIgnoreCase(floor))
                .findFirst()
                .orElse(Floor.MALE);
    }

}
