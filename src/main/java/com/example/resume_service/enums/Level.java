package com.example.resume_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 7:17 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */
@Getter
@AllArgsConstructor
public enum Level {
    MASTER(""),AVERAGE(""),SPECIALIZED(""),INCOMPLETE(""),HIGHER(""),BACHELOR(""),PHD(""),PH_D("");

    private String key;
}
