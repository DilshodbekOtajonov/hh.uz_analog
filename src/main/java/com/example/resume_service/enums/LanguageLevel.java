package com.example.resume_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 7:44 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@AllArgsConstructor
public enum LanguageLevel {
    A1("A1"),A2("A2"),B1("B1"),B2("B2"),C1("C1"),C2("C2");

    private String key;

    public static LanguageLevel findByName(String floor) {
        return Arrays.stream(LanguageLevel.values())
                .filter(floor1 -> floor1.name().equalsIgnoreCase(floor))
                .findFirst()
                .orElse(LanguageLevel.A1);
    }
}
