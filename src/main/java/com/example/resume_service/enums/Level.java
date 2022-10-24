package com.example.resume_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 7:17 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@AllArgsConstructor
public enum Level {
    MASTER("Master"),AVERAGE("Average"),SPECIALIZED("Specialized"),INCOMPLETE("Incomplete"),HIGHER("Higher"),BACHELOR("Bachelor"),PHD("PHD"),PH_D("PHD_D");

    private String key;

    public static Level findByName(String floor) {
        return Arrays.stream(Level.values())
                .filter(floor1 -> floor1.name().equalsIgnoreCase(floor))
                .findFirst()
                .orElse(Level.MASTER);
    }
}
