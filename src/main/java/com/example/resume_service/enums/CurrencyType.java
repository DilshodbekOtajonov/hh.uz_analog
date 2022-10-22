package com.example.resume_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author "Sodiqov Ogabek"
 * @since 10/20/2022 7:08 PM (Thursday)
 * Resume_service/IntelliJ IDEA
 */
@AllArgsConstructor
@Getter
public enum CurrencyType {
    RUB("RUB"),USD("USD"),EUR("EUR");

    public String key;
    public static CurrencyType findByName(String floor) {
        return Arrays.stream(CurrencyType.values())
                .filter(floor1 -> floor1.name().equalsIgnoreCase(floor))
                .findFirst()
                .orElse(CurrencyType.USD);
    }
}
